package com.cmsc508.db508project;

/**
 * Created by nathanwest on 4/19/18.
 */

public class Teacher {

    private String firstName, lastName;
    private String workEmail, personalEmail;
    private School school;

    public Teacher() {
        firstName = "";
        lastName = "";
        workEmail = "";
        personalEmail = "";
        school = null;

    }
    public Teacher(String firstName, String lastName, String workEmail, String personalEmail, School school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workEmail = workEmail;
        this.personalEmail = personalEmail;
        this.school = school;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", workEmail='" + workEmail + '\'' +
                ", personalEmail='" + personalEmail + '\'' +
                ", school=" + school +
                '}';
    }


}
