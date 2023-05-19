package com.lowtechsoft.asmjson;

@FunctionalInterface
public interface Mapping {

    KeyValuePair mapping(Object owner, KeyValuePair keyValuePair);
}
