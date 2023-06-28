package com.lowtechsoft.transfer.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONReader {
    private final String json;
    private final int total;
    private int index = 0;

    private int cursor = 0;

    public JSONReader(String json){
        if(json == null || json.isEmpty()){
            this.json = null;
            this.total = 0;
        }
        else{
            this.json = json;
            this.total = this.json.length();
        }
    }

    private void indexInc(){
        if(index < total - 1){
            index++;
        }
    }

    private boolean isTail(){
        return total - index == 1;
    }

    private void readTrim(){
        char c;
        boolean trim = false;
        while (index < total){
            c = json.charAt(index);
            switch (c){
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    trim = true;
                    break;
                default:
                    trim = false;
                    break;
            }
            if(trim){
                indexInc();
            }
            else{
                break;
            }
        }
    }

    private void throwJsonReadError(String error) throws Exception{
        int end = Math.min(index + 10, total);
        if(error == null || error.isEmpty()){
            error = json.substring(index, end);
        }
        throw new Exception("JSON Parse Error At Index[" + index + "]: " + error);
    }

    private String nextChars(int size) throws Exception{
        cursor = index + size;
        if(cursor >= total) {
            throwJsonReadError(null);
        }
        return json.substring(index, cursor);
    }

    private Object readNull() throws Exception{
        String str = nextChars(4);
        if(!"null".equals(str)){
            throwJsonReadError("read null failed");
        }
        index += 4;
        return null;
    }

    private String readString() throws Exception{
        StringBuilder sb = new StringBuilder();
        boolean match = false;
        for(cursor = index+1; cursor < total; cursor++){
            char c = json.charAt(cursor);
            if(c == '"'){
                char pre = json.charAt(cursor-1);
                if(pre != '\\'){
                    match = true;
                    cursor++;
                    break;
                }
            }
            sb.append(c);
        }
        if(!match){
            throwJsonReadError("read String error");
        }
        index = cursor;
        return sb.toString();
    }

    private Double readNumber() throws Exception{
        StringBuilder sb = new StringBuilder();
        boolean match = false;
        int dotCount = 0;
        int exponentCount = 0;
        for(cursor = index; cursor < total; cursor++){
            char c = json.charAt(cursor);
            switch (c){
                case '+':
                case '-':
                    if(cursor == index || json.charAt(cursor-1) == 'E'){
                        sb.append(c);
                    }
                    else{
                        throwJsonReadError("read Number Error");
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    sb.append(c);
                    break;
                case 'E':
                    exponentCount++;
                    if(exponentCount <= 1){
                        sb.append(c);
                    }
                    else{
                        throwJsonReadError("read Number Error");
                    }
                case '.':
                    dotCount++;
                    if(dotCount <= 1){
                        sb.append(c);
                    }
                    else{
                        throwJsonReadError("read Number Error");
                    }
                    break;
                default:
                    match = true;
                    break;
            }
            if(match){
                break;
            }
        }
        if(!match){
            throwJsonReadError("read Number Error");
        }
        index = cursor;
        return Double.parseDouble(sb.toString());
    }

    private boolean readTrue() throws Exception{
        String str = nextChars(4);
        if(!"true".equals(str)){
            throwJsonReadError("read true failed");
        }
        index += 4;
        return true;
    }

    private boolean readFalse() throws Exception{
        String str = nextChars(5);
        if(!"false".equals(str)){
            throwJsonReadError("read false failed");
        }
        index += 5;
        return false;
    }

    private List<Object> readList() throws Exception{
        List<Object> list = new ArrayList<>();
        indexInc();
        readTrim();
        char c = json.charAt(index);
        while(c != ']'){
            list.add(readObject());
            c = json.charAt(index);
        }
        indexInc();
        return list;
    }

    private Map<String,Object> readMap() throws Exception{
        Map<String, Object> map = new HashMap<>();
        indexInc();
        readTrim();
        char c = json.charAt(index);
        while (c != '}'){
            readTrim();
            String key = readString();
            readTrim();
            char sep = json.charAt(index);
            if(sep != ':'){
                throwJsonReadError("Parse Object Error");
            }
            indexInc();
            readTrim();
            Object val = readObject();
            map.put(key,val);
            c = json.charAt(index);
        }
        indexInc();
        return map;
    }

    private Object readObject() throws Exception{
        readTrim();
        JSONObjectType type = JSONObjectType.parse(json.charAt(index));
        Object ret = null;
        switch (type){
            case NULL:
                ret = readNull();
                break;
            case STRING:
                ret = readString();
                break;
            case NUMBER:
                ret = readNumber();
                break;
            case TRUE:
                ret = readTrue();
                break;
            case FALSE:
                ret = readFalse();
                break;
            case LIST:
                ret = readList();
                break;
            case MAP:
                ret = readMap();
                break;
            case ERROR:
                throwJsonReadError(null);
            default:
                break;
        }
        readTrim();
        if(index == total - 1){
            return ret;
        }
        char c = json.charAt(index);
        if(c == ','){
            indexInc();
            readTrim();
        }
        return ret;
    }

    public Object parse() throws Exception{
        if(total == 0)
            return null;
        return readObject();
    }

}
