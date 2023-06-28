package com.lowtechsoft.transfer.wrapper;

import java.util.Map;

public interface IModelWrapper {

    Map<String,Object> toMap();

    void unMap(Map<String,Object> map);

}
