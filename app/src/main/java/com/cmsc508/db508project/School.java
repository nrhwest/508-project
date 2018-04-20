package com.cmsc508.db508project;

/**
 * Created by nathanwest on 4/19/18.
 */

public class School {

    private int sID;
    private String name;
    private int phoneNum;
    private District district;
    private int numTeachers;

    public School() {
        sID = 0;
        name = "";
        phoneNum = 0;
        district = null;
        numTeachers = 0;
    }

    public School(int sID, String name, int phoneNum, District district, int numTeachers) {
        this.sID = sID;
        this.name = name;
        this.phoneNum = phoneNum;
        this.district = district;
        this.numTeachers = numTeachers;
    }

    public void setName(String n) { this.name = n; }

    public String getName() {
        return name;
    }

    public void setSID(int sID) { this.sID = sID; }

    public int getSID() {
        return sID;
    }

    public void setPhoneNum(int pn) { this.phoneNum = pn; }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setDistrict(District d) { this.district = d; }

    public District district() {
        return district;
    }

    public void setNumTeachers(int num) { this.numTeachers = num; }

    public int getNumTeachers() {
        return numTeachers;
    }

    @Override
    public String toString() {
        return "School{" +
                "sID=" + sID +
                ", name='" + name + '\'' +
                ", phoneNum=" + phoneNum +
                ", district=" + district +
                ", numTeachers=" + numTeachers +
                '}';
    }
}
