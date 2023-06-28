package com.lowtechsoft.transfer.model;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;

public class TestModel {

    private Deque<UserInfo> users;

    private DoctorDeptInfo<HospitalInfo, DeptInfo> manager;

    public void test(){
        this.manager = new DoctorDeptInfo<HospitalInfo, DeptInfo>();


    }

    public DoctorDeptInfo<HospitalInfo, DeptInfo> getManager() {
        return manager;
    }

    public void setManager(DoctorDeptInfo<HospitalInfo, DeptInfo> manager) {
        this.manager = manager;
    }

    public Deque<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(Deque<UserInfo> users) {
        this.users = users;
    }
}
