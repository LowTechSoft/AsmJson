package com.lowtechsoft.asmjson.json;

enum JSONObjectType {
    ERROR,
    NULL,
    STRING,
    NUMBER,
    TRUE,
    FALSE,
    MAP,
    LIST;

    static JSONObjectType parse(char c){
        JSONObjectType ret = ERROR;
        switch (c){
            case '"':
                ret = STRING;
                break;
            case '{':
                ret = MAP;
                break;
            case '[':
                ret = LIST;
                break;
            case 't':
                ret = TRUE;
                break;
            case 'f':
                ret = FALSE;
                break;
            case 'n':
                ret = NULL;
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
            case '.':
                ret = NUMBER;
                break;
        }
        return ret;
    }
}
