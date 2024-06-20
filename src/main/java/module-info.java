module com.example.academiaease {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.academiaease to javafx.fxml;
    exports com.example.academiaease;
}