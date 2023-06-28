package com.lowtechsoft.transfer.model;

public class DoctorDeptInfo<T extends OrgInfo, V extends DeptInfo> extends UserInfo{

    private T org;

    private V dept;

    public T getOrg() {
        return org;
    }

    public void setOrg(T org) {
        this.org = org;
    }

    public V getDept() {
        return dept;
    }

    public void setDept(V dept) {
        this.dept = dept;
    }
}
