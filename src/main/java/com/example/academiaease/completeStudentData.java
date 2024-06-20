package com.example.academiaease;

import java.sql.Date;

public class completeStudentData {
    private String firstName;
    private String lastName;
    private String department;
    private String course;
    private String gender;
    private Date birthdate;
    private String ParentFirstName;
    private String ParentLastName;
    private String ParentPhoneNumber;
    private String ParentEmail;
    private String ParentRelation;
    public completeStudentData (String firstName, String lastName, String department, String course, String gender, Date birthdate, String ParentFirstName, String ParentLastName, String ParentPhoneNumber, String ParentEmail, String ParentRelation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.course = course;
        this.gender = gender;
        this.birthdate = birthdate;
        this.ParentFirstName = ParentFirstName;
        this.ParentLastName = ParentLastName;
        this.ParentPhoneNumber = ParentPhoneNumber;
        this.ParentEmail = ParentEmail;
        this.ParentRelation = ParentRelation;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDepartment() {
        return department;
    }
    public String getCourse() {
        return course;
    }
    public String getGender() {
        return gender;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public String getParentFirstName() {
        return ParentFirstName;
    }
    public String getParentLastName() {
        return ParentLastName;
    }
    public String getParentPhoneNumber() {
        return ParentPhoneNumber;
    }
    public String getParentEmail() {
        return ParentEmail;
    }
    public String getParentRelation() {
        return ParentRelation;
    }
}
