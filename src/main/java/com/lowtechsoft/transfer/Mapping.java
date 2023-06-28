package com.lowtechsoft.transfer;

@FunctionalInterface
public interface Mapping {

    KeyValuePair mapping(Object owner, KeyValuePair keyValuePair);
}
