package com.lowtechsoft.transfer.model;

import java.util.List;

public class DeptInfo {
    private int id;
    private String name;

    private DoctorInfo manager;

    private List<DoctorInfo> doctors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoctorInfo getManager() {
        return manager;
    }

    public void setManager(DoctorInfo manager) {
        this.manager = manager;
    }

    public List<DoctorInfo> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorInfo> doctors) {
        this.doctors = doctors;
    }
}
