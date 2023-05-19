package com.lowtechsoft.asmjson.model;

import java.util.List;

public class HospitalInfo extends OrgInfo{

    private String level;

    private DoctorInfo director;

    private List<DeptInfo> departments;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public DoctorInfo getDirector() {
        return director;
    }

    public void setDirector(DoctorInfo director) {
        this.director = director;
    }

    public List<DeptInfo> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DeptInfo> departments) {
        this.departments = departments;
    }
}
