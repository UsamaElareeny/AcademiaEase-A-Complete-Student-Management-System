package com.example.academiaease;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class professorData {
    private final String first_name;
    private final String last_name;
    private final String department_name;
    private final String course_name;
    public professorData (String first_name, String last_name, String department_name, String course_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.department_name = department_name;
        this.course_name = course_name;
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
}
