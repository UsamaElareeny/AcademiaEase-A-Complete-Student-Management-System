package com.example.academiaease;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=AcademiaProject;integratedSecurity=true;trustServerCertificate=true";
    public static Connection getConnection() throws SQLException {
        try{
            Connection connection = DriverManager.getConnection(connectionString);
            return connection;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
