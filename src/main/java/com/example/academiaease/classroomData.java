package com.example.academiaease;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class classroomData {
    private final StringProperty classroom_name;
    private final IntegerProperty capacity;
    private final StringProperty location;

    public classroomData(String classroom_name, int capacity, String location) {
        this.classroom_name = new SimpleStringProperty(classroom_name);
        this.capacity = new SimpleIntegerProperty(capacity);
        this.location = new SimpleStringProperty(location);
    }
    public String getClassroom_name() {
        return classroom_name.get();
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name.set(classroom_name);
    }

    public StringProperty classroom_nameProperty() {
        return classroom_name;
    }

    public int getCapacity() {
        return capacity.get();
    }

    public void setCapacity(int capacity) {
        this.capacity.set(capacity);
    }

    public IntegerProperty capacityProperty() {
        return capacity;
    }

    public String getLocation() {
        return location.get();
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public StringProperty locationProperty() {
        return location;
    }
}
