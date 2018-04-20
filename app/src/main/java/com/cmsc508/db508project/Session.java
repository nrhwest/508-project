package com.cmsc508.db508project;

/**
 * Created by nathanwest on 4/20/18.
 */

public class Session {

    private String name, location, time;

    public Session(String name, String location, String time) {
        this.name = name;
        this.location = location;
        this.time = time;
    }

    public Session() {
        this.name = "";
        this.location = "";
        this.time = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Session{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
