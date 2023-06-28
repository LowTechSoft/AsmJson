package com.lowtechsoft.transfer.wrapper;

import com.lowtechsoft.transfer.model.DeptInfo;
import com.lowtechsoft.transfer.model.DoctorDeptInfo;
import com.lowtechsoft.transfer.model.HospitalInfo;

import java.util.HashMap;
import java.util.Map;

public class HospitalInfoWrapper implements IModelWrapper{
    private HospitalInfo model;

    public HospitalInfoWrapper(){
        this.model = new HospitalInfo();
    }

    public HospitalInfoWrapper(HospitalInfo model){
        this.model = model;
    }


    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("level", model.getLevel());

        return null;
    }


    public void unMap(Map<String,Object> map){
        DoctorDeptInfo<HospitalInfo, DeptInfo> info = new DoctorDeptInfo<>();

    }
}
