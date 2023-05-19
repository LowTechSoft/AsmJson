package com.lowtechsoft.asmjson.json;

import java.io.InputStream;
import java.util.ArrayList;
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
                    break;
            }
            if(trim){
                index++;
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
        cursor = index + 4;
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
        for(cursor = index; cursor < total; cursor++){
            char c = json.charAt(cursor);
            switch (c){
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
                case '.':
                    dotCount++;
                    if(dotCount <= 1){
                        sb.append(c);
                    }
                    else{
                        match = true;
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
        return Double.parseDouble(sb.toString());
    }

    private boolean readTrue() throws Exception{
        String str = nextChars(4);
        if(!"true".equals(str)){
            throwJsonReadError("read true failed");
        }
        return true;
    }

    private boolean readFalse() throws Exception{
        String str = nextChars(5);
        if(!"false".equals(str)){
            throwJsonReadError("read true failed");
        }
        return false;
    }

    private List<Object> readList() throws Exception{
        List<Object> list = new ArrayList<>();
        return null;
    }

    private Map<String,Object> readMap() throws Exception{
        return null;
    }

    public Object parse() throws Exception{
        if(total == 0)
            return null;

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
        return ret;
    }

}
