package com.example.academiaease;

import java.sql.Date;

public class studentData {
    private String first_name;
    private String last_name;
    private String department_name;
    private String course_name;
    private String gender;
    private Date birthdate;
    public studentData (String first_name, String last_name, String department_name, String course_name, Date birthdate, String gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.department_name = department_name;
        this.course_name = course_name;
        this.gender = gender;
        this.birthdate = birthdate;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getDepartment_name() {
        return department_name;
    }
    public String getCourse_name() {
        return course_name;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public String getGender() {
        return gender;
    }
}
