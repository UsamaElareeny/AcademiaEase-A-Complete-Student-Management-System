package com.example.academiaease;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController implements Initializable {
    private double x = 0;
    private double y = 0;

    @FXML
    private Button ForgotPasswordButton;

    @FXML
    private Button LoginButton;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    private AnchorPane MainFrame;

    @FXML
    private PasswordField RegisterConfirmPassword;

    @FXML
    private TextField RegisterEmail;

    @FXML
    private TextField RegisterName;

    @FXML
    private PasswordField RegisterPassword;

    @FXML
    private TextField RegisterUsername;

    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void LoginAdmin() throws SQLException {
        String SQLQuery = "SELECT * FROM admins WHERE username = ? AND password = ?";
        connect = DatabaseConnection.getConnection();
        try{
            Alert alert;
            preparedStatement = connect.prepareStatement(SQLQuery);
            preparedStatement.setString(1, username.getText());
            preparedStatement.setString(2, password.getText());
            resultSet = preparedStatement.executeQuery();

            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("CSSStyling/myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Username or password is empty");
                alert.showAndWait();
            }
            else{
                if (resultSet.next()){
                    MainFrame.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("Landing.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    root.setOnMousePressed((MouseEvent event) ->{
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event) ->{
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);

                        stage.setOpacity(.8);
                    });

                    root.setOnMouseReleased((MouseEvent event) ->{
                        stage.setOpacity(1);
                    });
                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();
                }
                else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("CSSStyling/myDialogs.css").toExternalForm());
                    dialogPane.getStyleClass().add("myDialog");
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong username or password");
                    alert.showAndWait();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean emailverify() {
        String email = RegisterEmail.getText();
        String emailRegex = "^[a-zA-Z][a-zA-Z0-9._%+-]*@gmail\\.com$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }


    public void register() throws SQLException {
        String insertData = "INSERT INTO admins "
                + "(full_name,email,username,password) "
                + "VALUES(?,?,?,?)";
        connect = DatabaseConnection.getConnection();
        try {
            Alert alert;
            if (RegisterName.getText().isEmpty() || RegisterEmail.getText().isEmpty() || RegisterUsername.getText().isEmpty() || RegisterPassword.getText().isEmpty() || RegisterConfirmPassword.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String checkData = "SELECT email FROM admins WHERE email = '"
                        + RegisterEmail.getText() + "'";
                Statement statement = connect.createStatement();
                resultSet = statement.executeQuery(checkData);
                if (resultSet.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("This email " + RegisterEmail.getText() + " already exists!");
                    alert.showAndWait();
                } else if (!RegisterConfirmPassword.getText().equals(RegisterPassword.getText())) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please check that the password and confirm password are the same");
                    alert.showAndWait();
                } else if (emailverify()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please ensure the email begins with a character and ends with @gmail.com");
                    alert.showAndWait();
                } else {
                    preparedStatement = connect.prepareStatement(insertData);
                    preparedStatement.setString(1, RegisterName.getText());
                    preparedStatement.setString(2, RegisterEmail.getText());
                    preparedStatement.setString(3, RegisterUsername.getText());
                    preparedStatement.setString(4, RegisterPassword.getText());
                    preparedStatement.executeUpdate();
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void Close(MouseEvent event) {
        System.exit(0);
    }
}



