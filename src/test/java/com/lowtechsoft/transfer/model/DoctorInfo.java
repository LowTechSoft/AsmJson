package com.lowtechsoft.transfer.model;

public class DoctorInfo extends UserInfo{

    private String title;

    private String beGoodAt;

    private String licenseNo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getBeGoodAt() {
        return beGoodAt;
    }

    public void setBeGoodAt(String beGoodAt) {
        this.beGoodAt = beGoodAt;
    }
}
