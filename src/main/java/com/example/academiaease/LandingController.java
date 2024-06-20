package com.example.academiaease;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class LandingController implements Initializable {
    double x = 0;
    double y = 0;

    @FXML
    private AnchorPane AvailibleCourse;

    @FXML
    private AnchorPane AvailibleCourse1;

    @FXML
    private Button CourseButton;

    @FXML
    private Button GradeButton;

    @FXML
    private AnchorPane Home;

    @FXML
    private Button HomeButton;

    @FXML
    private AnchorPane LandingPage;

    @FXML
    private AnchorPane LeftForm;

    @FXML
    private Button ManageButton;

    @FXML
    private AnchorPane ManageStaff;

    @FXML
    private AnchorPane ManageStaff1;

    @FXML
    private AnchorPane ManageStudent;

    @FXML
    private AnchorPane Payment;

    @FXML
    private Button PaymentButton;

    @FXML
    private Button SignOutButton;

    @FXML
    private Button StudentButton;

    @FXML
    private AnchorPane TopForm;

    @FXML
    private TableView<studentData> addStudents_tableView;

    @FXML
    private TableColumn<studentData, Date> col_birthdate;

    @FXML
    private TableColumn<studentData, String>col_course_name;

    @FXML
    private TableColumn<studentData, String> col_department_name;

    @FXML
    private TableColumn<studentData, String> col_first_name;

    @FXML
    private TableColumn<studentData, String>col_gender;

    ////////////
    @FXML
    private TableView<professorData> profTableView;

    @FXML
    private TableColumn<professorData, String> prof_first_name;
    @FXML
    private TableColumn<professorData, String> prof_last_name;
    @FXML
    private TableColumn<professorData, String> prof_department;
    @FXML
    private TableColumn<professorData, String> prof_course;
    @FXML
    private TextField professor_firstname;
    @FXML
    private TextField professor_lastname;

    ///////////
    ////////////////////////////////////////
    @FXML
    private TableView<paymentData> paymentTabelView;
    @FXML
    private TableColumn<paymentData, Integer> payment_student_id;
    @FXML
    private TableColumn<paymentData, String> payment_firstname;
    @FXML
    private TableColumn<paymentData, String> payment_lastname;
    @FXML
    private TableColumn<paymentData, Integer> payment_payment_amount;
    @FXML
    private TableColumn<paymentData, Date> payment_payment_date;


    /////////////////////////////////////////

    @FXML
    private TableColumn<studentData, String> col_last_name;

    @FXML
    private TableView<classroomData> addClassroom_tableView;

    @FXML
    private TableColumn<classroomData, Integer> col_capacity;

    @FXML
    private TableColumn<classroomData, String> col_classroom_name;

    @FXML
    private TableColumn<classroomData, String> col_location;
    @FXML

    private TableView<courseData> availibleCourse_tableView;
    @FXML
    private TableColumn<courseData, String> col_course_classroom_name;
    @FXML
    private TableColumn<courseData, String> col_course_department_name;
    @FXML
    private TableColumn<courseData, String> col_course_description;
    @FXML
    private TableColumn<courseData, String> col_course_course_name;


    @FXML
    private ImageView imageView;

    @FXML
    private Button minimizeButton;
    @FXML
    private ComboBox<String> chooseDepartment2;


    @FXML
    private ComboBox<String> chooseCourse;

    @FXML
    private ComboBox<String> chooseClassroom;

    @FXML
    private ComboBox<String> chooseDepartment;
    @FXML
    private ComboBox<String> chooseDepartment1;
    @FXML ComboBox<String> chooseCourse2;


    @FXML
    private ComboBox<String> chooseRelation;

    @FXML
    private ComboBox<String> ChooseGender;


    @FXML
    private TextField StudentFirstName;

    @FXML
    private TextField StudentLastName;

    @FXML
    private TextField ParentEmail;

    @FXML
    private TextField ParentFirstName;

    @FXML
    private TextField ParentLastName;

    @FXML
    private TextField ParentPhoneNumber;

    @FXML
    private DatePicker studentBirthdate;
    @FXML
    private TextField courseField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField TextFieldClassroom;

    @FXML
    private TextField TextFieldCapacity;
    @FXML
    private TextField TextFieldLocation;
    /////////////////////////////////////////////
    @FXML
    private TextField payment_student_firstname;
    @FXML
    private TextField payment_student_lastname;
    @FXML
    private TextField payment_payment_amountt;
    @FXML
    private DatePicker payment_payment_datte;

    //////////////////////////////////////////////

    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    @FXML
    private Label totalstudents;
    @FXML
    private Label totalmale;
    @FXML
    private Label totalfemale;
    @FXML
    private Label totalprofessors;
    @FXML
    private Label totalcourses;
    @FXML
    private Label totaldepartments;
                                                                            /* Home */
    /*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    public void ShowStats() throws SQLException{
        String TotalSutdentsSQL = "SELECT COUNT(*) FROM students;";
        String TotalMaleSutdentsSQL = "SELECT COUNT(*) FROM students where gender = 'male';";
        String TotalFemaleSutdentsSQL = "SELECT COUNT(*) FROM students where gender = 'female';";
        String TotalProfessorssSQL = "SELECT COUNT(*) FROM professors;";
        String TotaldepartmentsSQL = "SELECT COUNT(*) FROM departments;";
        String TotalcoursesSQL = "SELECT COUNT(*) FROM courses;";
        int totalnumberstudents = 0;
        int totalmalestudents = 0;
        int totalfemalestudents = 0;
        int totalnumberprofessors = 0;
        int totalnumbercourses = 0;
        int totalnumberdepartments = 0;
        try {
            preparedStatement = connection.prepareStatement(TotalSutdentsSQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                totalnumberstudents = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            preparedStatement = connection.prepareStatement(TotalMaleSutdentsSQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                totalmalestudents = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            preparedStatement = connection.prepareStatement(TotalFemaleSutdentsSQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                totalfemalestudents = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            preparedStatement = connection.prepareStatement(TotalProfessorssSQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                totalnumberprofessors = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            preparedStatement = connection.prepareStatement(TotalcoursesSQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                totalnumbercourses = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            preparedStatement = connection.prepareStatement(TotaldepartmentsSQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                totalnumberdepartments = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        totalstudents.setText(String.valueOf(totalmalestudents));
        totalmale.setText(String.valueOf(totalnumberstudents));
        totalfemale.setText(String.valueOf(totalfemalestudents));
        totalprofessors.setText(String.valueOf(totalnumberprofessors));
        totalcourses.setText(String.valueOf(totalnumbercourses));
        totaldepartments.setText(String.valueOf(totalnumberdepartments));


    }
    /*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/

                                                                             /* Manage Students */
    /*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/

    private String[] genderList = {"Male", "Female"};
    public void addStudentsGenderList() {
        ObservableList<String> genderObservableList = FXCollections.observableArrayList(genderList);
        ChooseGender.setItems(genderObservableList);
    }

    private String[] relation = {"Father", "Mother", "Other"};
    public void addRelationList() {
        ObservableList<String> relationObservableList = FXCollections.observableArrayList(relation);
        chooseRelation.setItems(relationObservableList);
    }

    public void addCourseList() throws SQLException {
        String SQL = "SELECT course_name FROM courses;";
        connection = DatabaseConnection.getConnection();
        List<String> courseList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                courseList.add(resultSet.getString("course_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList<String> observableCourseList = FXCollections.observableArrayList(courseList);
        chooseCourse.setItems(observableCourseList);
    }

    public void addDepartmentList1() throws SQLException {
        String SQL = "SELECT department_name from departments;";
        connection = DatabaseConnection.getConnection();
        List<String> departmentList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departmentList.add(resultSet.getString("department_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList<String> observableDepartmentList = FXCollections.observableArrayList(departmentList);
        chooseDepartment1.setItems(observableDepartmentList);
    }
    public boolean parentExists(String fname, String lname, String phone) {
        boolean exists = false;
        String sql = "SELECT * FROM parents WHERE fname = ? AND lname = ? AND phone = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, phone);

            ResultSet rs = pstmt.executeQuery();
            exists = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }
    public int insertParentAndGetId(String firstName, String lastName, String phone, String email, String relation) {
        int parentId = -1;
        String sql = "INSERT INTO parents (fname, lname, phone, email, relation) OUTPUT INSERTED.parent_id VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phone);
            pstmt.setString(4, email);
            pstmt.setString(5, relation);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                parentId = rs.getInt("parent_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parentId;
    }
    public void insertStudent(String firstName, String lastName, int departmentId, int courseId, int parentId, Date birthdate, String gender) {
        String insertDataintoStudents = "INSERT INTO students (first_name, last_name, department_id, course_id, parent_id, birthdate, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(insertDataintoStudents)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, departmentId);
            pstmt.setInt(4, courseId);
            pstmt.setInt(5, parentId);
            pstmt.setDate(6, birthdate);
            pstmt.setString(7, gender);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getParentId(String firstName, String lastName, String phone) {
        int parentId = -1;
        String sql = "SELECT parent_id FROM parents WHERE fname = ? AND lname = ? AND phone = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phone);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                parentId = rs.getInt("parent_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parentId;
    }
    public int getDepartmentId(String departmentName) throws SQLException {
        String departmentQuery = "SELECT department_id FROM departments WHERE department_name = ?";
        try (PreparedStatement departmentStatement = connection.prepareStatement(departmentQuery)) {
            departmentStatement.setString(1, departmentName);
            try (ResultSet departmentResultSet = departmentStatement.executeQuery()) {
                if (departmentResultSet.next()) {
                    return departmentResultSet.getInt("department_id");
                }
            }
        }
        // Return -1 if department is not found
        return -1;
    }
    public int getCourseId(String courseName) throws SQLException {
        String courseQuery = "SELECT course_id FROM courses WHERE course_name = ?";
        try (PreparedStatement courseStatement = connection.prepareStatement(courseQuery)) {
            courseStatement.setString(1, courseName);
            try (ResultSet courseResultSet = courseStatement.executeQuery()) {
                if (courseResultSet.next()) {
                    return courseResultSet.getInt("course_id");
                }
            }
        }
        // Return -1 if course is not found
        return -1;
    }
    public void addStudent() throws SQLException {
        String insertDataintoStudents = "INSERT INTO students (first_name, last_name, department_id, course_id, parent_id, birthdate, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String departmentQuery = "SELECT department_id FROM departments WHERE department_name = ?";
        String courseQuery = "SELECT course_id FROM courses WHERE course_name = ?";

        // Get department_id
        int departmentId = getDepartmentId(chooseDepartment1.getValue());

        // Get course_id
        int courseId = getCourseId(chooseCourse.getValue());

        if (parentExists(ParentFirstName.getText(), ParentLastName.getText(), ParentPhoneNumber.getText())) {
            int parentId = getParentId(ParentFirstName.getText(), ParentLastName.getText(), ParentPhoneNumber.getText());
            insertStudent(StudentFirstName.getText(), StudentLastName.getText(), departmentId, courseId, parentId, Date.valueOf(studentBirthdate.getValue()), ChooseGender.getValue());
        } else {
            // Parent does not exist, insert parent first
            int parentId = insertParentAndGetId(ParentFirstName.getText(), ParentLastName.getText(), ParentPhoneNumber.getText(), ParentEmail.getText(), chooseRelation.getValue());
            insertStudent(StudentFirstName.getText(), StudentLastName.getText(), departmentId, courseId, parentId, Date.valueOf(studentBirthdate.getValue()), ChooseGender.getValue());
        }
        addStudentsShowListData();

    }


    public void addStudentsSelect() throws SQLException {
        int num = addStudents_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        studentData studentD = addStudents_tableView.getSelectionModel().getSelectedItem();
        String first_name = String.valueOf(studentD.getFirst_name());
        String last_name = studentD.getLast_name();
        StudentFirstName.setText(first_name);
        StudentLastName.setText(last_name);
        studentBirthdate.setValue(LocalDate.parse(String.valueOf(studentD.getBirthdate())));
        ChooseGender.setValue(String.valueOf(studentD.getGender()));
        chooseCourse.setValue(String.valueOf(studentD.getCourse_name()));
        chooseDepartment1.setValue(String.valueOf(studentD.getDepartment_name()));

        String SQL = "SELECT parent_id from students WHERE first_name = ? AND last_name = ?;";
        connection = DatabaseConnection.getConnection();


        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int parent_id = rs.getInt("parent_id");
                String parentSQL = "SELECT * FROM parents WHERE parent_id = ?";
                try (PreparedStatement parentStmt = connection.prepareStatement(parentSQL)) {
                    parentStmt.setInt(1, parent_id);
                    ResultSet parentRs = parentStmt.executeQuery();
                    if (parentRs.next()) {
                        String fname = parentRs.getString("fname");
                        String lname = parentRs.getString("lname");
                        String phone = parentRs.getString("phone");
                        String email = parentRs.getString("email");
                        String relation = parentRs.getString("relation");
                        ParentFirstName.setText(fname);
                        ParentLastName.setText(lname);
                        ParentPhoneNumber.setText(phone);
                        ParentEmail.setText(email);
                        chooseRelation.setValue(relation);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<studentData> addStudentsListData() throws SQLException {
        ObservableList<studentData> listStudents = FXCollections.observableArrayList();
        String SQL = "SELECT s.first_name, s.last_name, d.department_name, c.course_name, birthdate, gender FROM students s JOIN courses c ON s.course_id = c.course_id JOIN departments d ON s.department_id = d.department_id;";
        connection = DatabaseConnection.getConnection();
        try {
            studentData studentD;
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                studentD = new studentData(resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("department_name"),
                        resultSet.getString("course_name"),
                        resultSet.getDate("birthdate"),
                        resultSet.getString("gender"));

                listStudents.add(studentD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }
    private ObservableList<studentData> addStudentsListD;
    public void addStudentsShowListData() throws SQLException {
        addStudentsListD = addStudentsListData();

        col_first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        col_last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        col_department_name.setCellValueFactory(new PropertyValueFactory<>("department_name"));
        col_course_name.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        col_birthdate.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        addStudents_tableView.setItems(addStudentsListD);
    }
    public int getNumberOfStudentsWithParentId(int parentId) {
        int numberOfStudents = 0;
        String sql = "SELECT COUNT(*) AS count FROM students WHERE parent_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, parentId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                numberOfStudents = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfStudents;
    }
    public int getStudentId(String firstName, String lastName, int departmentId, int courseId, int parentId, Date birthdate, String gender) {
        int studentId = -1; // Default value if student is not found
        String sql = "SELECT student_id FROM students WHERE first_name = ? AND last_name = ? AND department_id = ? AND course_id = ? AND parent_id = ? AND birthdate = ? AND gender = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, departmentId);
            pstmt.setInt(4, courseId);
            pstmt.setInt(5, parentId);
            pstmt.setDate(6, birthdate);
            pstmt.setString(7, gender);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                studentId = rs.getInt("student_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentId;
    }
    public void deleteStudentbyID(int studentId) {
        String deleteQuery = "DELETE FROM students WHERE student_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteParentbyID(int parentId) {
        String deleteQuery = "DELETE FROM parents WHERE parent_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, parentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent() throws SQLException {
        int parentId = getParentId (ParentFirstName.getText(), ParentLastName.getText(), ParentPhoneNumber.getText());
        int departmentId = getDepartmentId(chooseDepartment1.getValue());
        int courseId = getCourseId(chooseCourse.getValue());
        int StudentID = getStudentId(StudentFirstName.getText(), StudentLastName.getText(), departmentId, courseId, parentId, Date.valueOf(studentBirthdate.getValue()), ChooseGender.getValue());
        if (getNumberOfStudentsWithParentId(parentId) > 1){
            deleteStudentbyID(StudentID);
        }
        // The parent has only one son in school and now he is gone, I should delete the parent too.
        else{
            // Deleting Student
            deleteStudentbyID(StudentID);
            // Deleting Parent
            deleteParentbyID(parentId);
        }
        addStudentsShowListData();
    }

    /* //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// */




                                    /* Courses & Classrooms */
    /* //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// */

                                        /* Courses */
    public void addClassroomList() throws SQLException {
        String SQL = "SELECT classroom_name from classrooms;";
        connection = DatabaseConnection.getConnection();
        List<String> classroomList = new ArrayList<>();
        try {
            assert connection != null;
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                classroomList.add(resultSet.getString("classroom_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList<String> observableClassroomList = FXCollections.observableArrayList(classroomList);
        chooseClassroom.setItems(observableClassroomList);
    }
    public void addDepartmentList() throws SQLException {
        String SQL = "SELECT department_name from departments;";
        connection = DatabaseConnection.getConnection();
        List<String> departmentList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departmentList.add(resultSet.getString("department_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList<String> observableDepartmentList = FXCollections.observableArrayList(departmentList);
        chooseDepartment.setItems(observableDepartmentList);
    }
    public ObservableList<courseData> availibleCourseData() throws SQLException {
        ObservableList<courseData> listData = FXCollections.observableArrayList();

        String SQL = "SELECT c.course_name, c.description, d.department_name, cl.classroom_name FROM courses c JOIN classrooms cl ON c.classroom_id = cl.classroom_id JOIN departments d ON c.department_id = d.department_id;";
        connection = DatabaseConnection.getConnection();
        try {
            courseData courseD;
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                courseD = new courseData(resultSet.getString("course_name"),
                        resultSet.getString("description"),
                        resultSet.getString("department_name"),
                        resultSet.getString("classroom_name"));

                listData.add(courseD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<courseData> availibleCourseList;
    public void availibleCourseShowListData() throws SQLException {
        availibleCourseList = availibleCourseData();

        col_course_course_name.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        col_course_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_course_department_name.setCellValueFactory(new PropertyValueFactory<>("department_name"));
        col_course_classroom_name.setCellValueFactory(new PropertyValueFactory<>("classroom_name"));

        availibleCourse_tableView.setItems(availibleCourseList);
    }

    public void availibleCourseSelect(){
        int num = availibleCourse_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        courseData courseD = availibleCourse_tableView.getSelectionModel().getSelectedItem();
        courseField.setText(String.valueOf(courseD.getCourse_name()));
        descriptionField.setText(String.valueOf(courseD.getDescription()));
        chooseDepartment.setValue(String.valueOf(courseD.getDepartment_name()));
        chooseClassroom.setValue(String.valueOf(courseD.getClassroom_name()));
    }
    public void availableCourseAdd() throws SQLException{
        String departmentQuery = "SELECT department_id FROM departments WHERE department_name = ?";
        String classroomQuery = "SELECT classroom_id FROM classrooms WHERE classroom_name = ?";
        String insertData = "INSERT INTO courses (course_name, department_id, classroom_id, description) VALUES (?, ?, ?, ?)";

        try {
            // Get department_id
            PreparedStatement departmentStatement = connection.prepareStatement(departmentQuery);
            departmentStatement.setString(1, chooseDepartment.getValue());
            ResultSet departmentResultSet = departmentStatement.executeQuery();

            int departmentId = -1; // Default value if department is not found
            if (departmentResultSet.next()) {
                departmentId = departmentResultSet.getInt("department_id");
            }

            // Get classroom_id
            PreparedStatement classroomStatement = connection.prepareStatement(classroomQuery);
            classroomStatement.setString(1, chooseClassroom.getValue());
            ResultSet classroomResultSet = classroomStatement.executeQuery();

            int classroomId = -1; // Default value if classroom is not found
            if (classroomResultSet.next()) {
                classroomId = classroomResultSet.getInt("classroom_id");
            }

            // Insert data
            PreparedStatement insertStatement = connection.prepareStatement(insertData);
            insertStatement.setString(1, courseField.getText());
            insertStatement.setInt(2, departmentId);
            insertStatement.setInt(3, classroomId);
            insertStatement.setString(4, descriptionField.getText());

            insertStatement.executeUpdate();

            availibleCourseShowListData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void availableCourseDelete() throws SQLException{
        String deleteData = "DELETE FROM courses WHERE course_name = '"
                + courseField.getText() + "'";

        connection = DatabaseConnection.getConnection();
        try{
            PreparedStatement deleteStatement = connection.prepareStatement(deleteData);
            deleteStatement.executeUpdate();
            availibleCourseShowListData();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

                                             /* Classrooms */

    public ObservableList<classroomData> availibleClassroomData() throws SQLException {
        ObservableList<classroomData> listData = FXCollections.observableArrayList();

        String SQL = "SELECT classroom_name, capacity, location from classrooms;";
        connection = DatabaseConnection.getConnection();
        try {
            classroomData myclassroomData;
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                myclassroomData = new classroomData(resultSet.getString("classroom_name"),
                        resultSet.getInt("capacity"),
                        resultSet.getString("location"));
                listData.add(myclassroomData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<classroomData> classroomList;
    public void ClassroomShowListData() throws SQLException {
        classroomList = availibleClassroomData();

        col_classroom_name.setCellValueFactory(new PropertyValueFactory<>("classroom_name"));
        col_capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        col_location.setCellValueFactory(new PropertyValueFactory<>("location"));

        addClassroom_tableView.setItems(classroomList);
    }
    public void availableClassroomAdd() throws SQLException{
        String insertData = "INSERT INTO classrooms (classroom_name, capacity, location) VALUES (?, ?, ?)";
        try {
            // Insert data
            PreparedStatement insertStatement = connection.prepareStatement(insertData);
            insertStatement.setString(1, TextFieldClassroom.getText());
            insertStatement.setInt(2, Integer.parseInt(TextFieldCapacity.getText()));
            insertStatement.setString(3, TextFieldLocation.getText());

            insertStatement.executeUpdate();

            ClassroomShowListData();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public void availibleClassroomSelect(){
        int num = addClassroom_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        classroomData classD = addClassroom_tableView.getSelectionModel().getSelectedItem();
        TextFieldClassroom.setText(String.valueOf(classD.getClassroom_name()));
        TextFieldCapacity.setText(String.valueOf(classD.getCapacity()));
        TextFieldLocation.setText(String.valueOf(classD.getLocation()));
    }
    public void availableClassroomDelete() throws SQLException{
        String deleteData = "DELETE FROM classrooms WHERE classroom_name = '"
                + TextFieldClassroom.getText() + "'";

        connection = DatabaseConnection.getConnection();
        try{
            PreparedStatement deleteStatement = connection.prepareStatement(deleteData);
            deleteStatement.executeUpdate();
            ClassroomShowListData();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* /////////////////////////////////////////////////////////////////////////////////////// */
                                        /* Professors */
    public ObservableList<professorData> manageProfessorShowList() throws SQLException {
        ObservableList<professorData> listProfessors = FXCollections.observableArrayList();
        String SQL = "SELECT p.first_name, p.last_name, d.department_name, c.course_name FROM professors p JOIN courses c ON p.course_id = c.course_id JOIN departments d ON p.department_id = d.department_id;";
        connection = DatabaseConnection.getConnection();
        try {
            professorData proffD;
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                proffD = new professorData(resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("department_name"),
                        resultSet.getString("course_name"));

                listProfessors.add(proffD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProfessors;
    }
    private ObservableList<professorData> addProffessorD;
    public void manageProfessorsShowListData() throws SQLException {
        addProffessorD = manageProfessorShowList();

        prof_first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        prof_last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        prof_department.setCellValueFactory(new PropertyValueFactory<>("department_name"));
        prof_course.setCellValueFactory(new PropertyValueFactory<>("course_name"));

        profTableView.setItems(addProffessorD);
    }
    public void addDepartmentList2() throws SQLException {
        String SQL = "SELECT department_name from departments;";
        connection = DatabaseConnection.getConnection();
        List<String> departmentList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departmentList.add(resultSet.getString("department_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList<String> observableDepartmentList = FXCollections.observableArrayList(departmentList);
        chooseDepartment2.setItems(observableDepartmentList);
    }
    public void addCourseList2() throws SQLException {
        String SQL = "SELECT course_name FROM courses;";
        connection = DatabaseConnection.getConnection();
        List<String> courseList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                courseList.add(resultSet.getString("course_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList<String> observableCourseList = FXCollections.observableArrayList(courseList);
        chooseCourse2.setItems(observableCourseList);
    }
    public void manageProfessorsSelect(){
        int num = profTableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        professorData professorData = profTableView.getSelectionModel().getSelectedItem();
        professor_firstname.setText(String.valueOf(professorData.getFirst_name()));
        professor_lastname.setText(String.valueOf(professorData.getLast_name()));
        chooseDepartment2.setValue(String.valueOf(professorData.getDepartment_name()));
        chooseCourse2.setValue(String.valueOf(professorData.getCourse_name()));
    }
    public void addProfessor() throws SQLException {
        String insertDataintoProfessors = "INSERT INTO professors (first_name, last_name, department_id, course_id) VALUES (?, ?, ?, ?)";

        // Get department_id
        int departmentId = getDepartmentId(chooseDepartment2.getValue());

        // Get course_id
        int courseId = getCourseId(chooseCourse2.getValue());

        PreparedStatement insertStatement = connection.prepareStatement(insertDataintoProfessors);
        insertStatement.setString(1, professor_firstname.getText());
        insertStatement.setString(2, professor_lastname.getText());
        insertStatement.setInt(3, departmentId);
        insertStatement.setInt(4, courseId);

        insertStatement.executeUpdate();

        manageProfessorsShowListData();

    }
    public int getProfessorId(String first_name, String last_name, int department_id, int course_id) {
        int professorId = -1; // Default value if student is not found
        String sql = "SELECT professors_id FROM professors WHERE first_name = ? AND last_name = ? AND department_id = ? AND course_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setInt(3, department_id);
            pstmt.setInt(4, course_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                professorId = rs.getInt("professors_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professorId;
    }
    public void manageProfessorDelete() throws SQLException{
        String deleteData = "DELETE FROM professors WHERE professors_id = ?;";
        int departmentId = getDepartmentId(chooseDepartment2.getValue());
        int courseId = getCourseId(chooseCourse2.getValue());
        int profId = getProfessorId(professor_firstname.getText(), professor_lastname.getText(), departmentId, courseId);
        PreparedStatement insertStatement = connection.prepareStatement(deleteData);

        insertStatement.setInt(1, profId);
        insertStatement.executeUpdate();

        manageProfessorsShowListData();
    }

    /* /////////////////////////////////////////////////////////////////////////////////////// */


    /* /////////////////////////////////////////////////////////////////////////////////////// */
                                        /* Payments */
    public ObservableList<paymentData> paymentShowList() throws SQLException {
        ObservableList<paymentData> listPayment = FXCollections.observableArrayList();
        String SQL = "SELECT student_id, student_firstname, student_lastname, payment_amount, payment_date FROM payments;";
        connection = DatabaseConnection.getConnection();
        try {
            paymentData paymentD;
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                paymentD = new paymentData(resultSet.getInt("student_id"),
                        resultSet.getString("student_firstname"),
                        resultSet.getString("student_lastname"),
                        resultSet.getInt("payment_amount"),
                        resultSet.getDate("payment_date")
                        );

                listPayment.add(paymentD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPayment;
    }
    private ObservableList<paymentData> addPaymentD;
    public void paymentShowListData() throws SQLException {
        addPaymentD = paymentShowList();

        payment_student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        payment_firstname.setCellValueFactory(new PropertyValueFactory<>("student_firstname"));
        payment_lastname.setCellValueFactory(new PropertyValueFactory<>("student_lastname"));
        payment_payment_amount.setCellValueFactory(new PropertyValueFactory<>("payment_amount"));
        payment_payment_date.setCellValueFactory(new PropertyValueFactory<>("payment_date"));

        paymentTabelView.setItems(addPaymentD);
    }
    public void paymentsSelect(){
        int num = paymentTabelView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        paymentData paymentD = paymentTabelView.getSelectionModel().getSelectedItem();
        payment_student_firstname.setText(String.valueOf(paymentD.getStudent_firstname()));
        payment_student_lastname.setText(String.valueOf(paymentD.getStudent_lastname()));
        payment_payment_amountt.setText(String.valueOf(paymentD.getPayment_amount()));
        payment_payment_datte.setValue(LocalDate.parse(String.valueOf(paymentD.getPayment_date())));
    }
    public int getPaymentID(String student_firstname, String student_lastname, int payment_amount, Date payment_date) throws SQLException {
        int paymentId = -1;
        String sql = "SELECT payment_id FROM payments WHERE student_firstname = ? AND student_lastname = ? AND payment_amount = ? AND payment_date = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, student_firstname);
            pstmt.setString(2, student_lastname);
            pstmt.setInt(3, payment_amount);
            pstmt.setDate(4, payment_date);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                paymentId = rs.getInt("payment_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paymentId;
    }

    public void paymentDelete() throws SQLException {
        String deleteData = "DELETE FROM payments WHERE payment_id = ?";
        String studentFirstName = payment_student_firstname.getText();
        String studentLastName = payment_student_lastname.getText();
        int paymentAmount = Integer.parseInt(payment_payment_amountt.getText());
        LocalDate paymentDate = payment_payment_datte.getValue();
        Date sqlDate = Date.valueOf(paymentDate);

        int parentId = getPaymentID(studentFirstName, studentLastName, paymentAmount, sqlDate);

        if (parentId != -1) {
            connection = DatabaseConnection.getConnection();
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteData)) {
                deleteStatement.setInt(1, parentId);
                deleteStatement.executeUpdate();
                paymentShowListData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Payment ID not found.");
        }
    }
    public int getStudentIdByFirstLastName(String firstName, String lastName) {
        int studentId = -1; // Default value if student is not found
        String sql = "SELECT student_id FROM students WHERE first_name = ? AND last_name = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                studentId = rs.getInt("student_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentId;
    }
    public void paymentAdd() throws SQLException {
        String insertData = "INSERT INTO payments (student_id, student_firstname, student_lastname, payment_amount, payment_date) VALUES (?, ?, ?, ?, ?)";
        String studentFirstName = payment_student_firstname.getText();
        String studentLastName = payment_student_lastname.getText();
        int studentId = getStudentIdByFirstLastName(studentFirstName, studentLastName);
        int paymentAmount = Integer.parseInt(payment_payment_amountt.getText());
        LocalDate paymentDate = payment_payment_datte.getValue();
        Date sqlDate = Date.valueOf(paymentDate);
        if (studentId != -1){
            connection = DatabaseConnection.getConnection();
            try (PreparedStatement insertStatement = connection.prepareStatement(insertData)) {
                insertStatement.setInt(1, studentId);
                insertStatement.setString(2, studentFirstName);
                insertStatement.setString(3, studentLastName);
                insertStatement.setInt(4, paymentAmount);
                insertStatement.setDate(5, sqlDate);
                insertStatement.executeUpdate();
                paymentShowListData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            showAlert("Student Not Found", "No student found with this first and last name");
        }
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    /* /////////////////////////////////////////////////////////////////////////////////////// */


    public void switchForm(javafx.event.ActionEvent event) throws IOException, SQLException {
        Home.setVisible(true);
        LeftForm.setVisible(true);
        TopForm.setVisible(true);
        if (event.getSource() == HomeButton){
            Home.setVisible(true);
            ManageStudent.setVisible(false);
            ManageStaff.setVisible(false);
            ManageStaff1.setVisible(false);
            AvailibleCourse.setVisible(false);
            AvailibleCourse1.setVisible(false);
            Payment.setVisible(false);

            ShowStats();

        }
        else if (event.getSource() == StudentButton){
            Home.setVisible(false);
            ManageStudent.setVisible(true);
            ManageStaff.setVisible(false);
            ManageStaff1.setVisible(false);
            AvailibleCourse.setVisible(false);
            AvailibleCourse1.setVisible(false);
            Payment.setVisible(false);

            addCourseList();
            addDepartmentList1();
            addRelationList();
            addStudentsGenderList();
            addStudentsShowListData();
        }
        else if (event.getSource() == ManageButton){
            Home.setVisible(false);
            ManageStudent.setVisible(false);
            ManageStaff.setVisible(true);
            ManageStaff1.setVisible(true);
            AvailibleCourse.setVisible(false);
            AvailibleCourse1.setVisible(false);
            Payment.setVisible(false);

            addCourseList2();
            addDepartmentList2();
            manageProfessorsShowListData();
        }
        else if (event.getSource() == CourseButton){
            Home.setVisible(false);
            ManageStudent.setVisible(false);
            ManageStaff.setVisible(false);
            ManageStaff1.setVisible(false);
            AvailibleCourse.setVisible(true);
            AvailibleCourse1.setVisible(true);
            Payment.setVisible(false);

            addClassroomList();
            addDepartmentList();
            ClassroomShowListData();
            availibleCourseShowListData();
        }
        else if (event.getSource() == PaymentButton){
            Home.setVisible(false);
            ManageStudent.setVisible(false);
            ManageStaff.setVisible(false);
            ManageStaff1.setVisible(false);
            AvailibleCourse.setVisible(false);
            AvailibleCourse1.setVisible(false);
            Payment.setVisible(true);

            paymentShowListData();
        }
    }
    public void LogOut() throws IOException {
        SignOutButton.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
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
        stage.show();
    }

    public void close(){
        System.exit(0);
    }
    public void minimize(){
        Stage stage = (Stage)LandingPage.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            addClassroomList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            addStudentsShowListData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            addCourseList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            addDepartmentList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        addRelationList();
        addStudentsGenderList();
        try {
            availibleCourseShowListData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ClassroomShowListData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            addDepartmentList1();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            addDepartmentList2();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            addCourseList2();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            manageProfessorsShowListData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            paymentShowListData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ShowStats();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

}
