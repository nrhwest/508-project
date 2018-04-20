package com.cmsc508.db508project;

/**
 * Created by nathanwest on 4/19/18.
 */

class District {

    private String name;
    private String superinterdent;
    private int numOfTeachers;

    public District(String name, String superinterdent, int numOfTeachers) {
        this.name = name;
        this.superinterdent = superinterdent;
        this.numOfTeachers = numOfTeachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperinterdent() {
        return superinterdent;
    }

    public void setSuperinterdent(String superinterdent) {
        this.superinterdent = superinterdent;
    }

    public int getNumOfTeachers() {
        return numOfTeachers;
    }

    public void setNumOfTeachers(int numOfTeachers) {
        this.numOfTeachers = numOfTeachers;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", superinterdent='" + superinterdent + '\'' +
                ", numOfTeachers=" + numOfTeachers +
                '}';
    }
}
