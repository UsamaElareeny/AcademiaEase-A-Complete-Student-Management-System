package com.example.academiaease;

public class courseData {
    private String course_name;
    private String description;
    private String department_name;
    private String classroom_name;
    public courseData(String course_name, String description, String department_name, String classroom_name) {
        this.course_name = course_name;
        this.description = description;
        this.department_name = department_name;
        this.classroom_name = classroom_name;
    }
    public String getCourse_name() {
        return course_name;
    }
    public String getDescription() {
        return description;
    }
    public String getDepartment_name() {
        return department_name;
    }
    public String getClassroom_name() {
        return classroom_name;
    }

}
