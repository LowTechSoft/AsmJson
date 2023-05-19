package com.lowtechsoft.asmjson.wrapper;

import com.lowtechsoft.asmjson.model.HospitalInfo;

public class HospitalInfoWrapper implements IModelWrapper{
    private HospitalInfo model;

    public HospitalInfoWrapper(){
        this.model = new HospitalInfo();
    }

    public HospitalInfoWrapper(HospitalInfo model){
        this.model = model;
    }



}
