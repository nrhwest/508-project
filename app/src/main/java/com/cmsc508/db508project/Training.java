package com.cmsc508.db508project;

import java.util.Date;

/**
 * Created by nathanwest on 4/19/18.
 */

public class Training {
    private String name;
    private int maxCapacity;
    private boolean stipend;
    private int numOfReg;
    private Date date;
    private String gradeLevel;

    public Training() {
        name = "";
        maxCapacity = 0;
        stipend = false;
        numOfReg = 0;
        date = null;
        gradeLevel = "";
    }

    public Training(String name, int maxCapacity, boolean stipend, int numOfReg, String gradeLevel) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.stipend = false;
        this.numOfReg = numOfReg;
        this.gradeLevel = gradeLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean isStipend() {
        return stipend;
    }

    public void setStipend(boolean stipend) {
        this.stipend = stipend;
    }

    public int getNumOfReg() {
        return numOfReg;
    }

    public void setNumOfReg(int numOfReg) {
        this.numOfReg = numOfReg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    @Override
    public String toString() {
        return "Training{" +
                "name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", stipend=" + stipend +
                ", numOfReg=" + numOfReg +
                ", date=" + date +
                ", gradeLevel='" + gradeLevel + '\'' +
                '}';
    }
}
