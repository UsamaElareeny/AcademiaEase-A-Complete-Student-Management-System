package com.example.academiaease;

import java.sql.Date;

public class paymentData {
    private int student_id;
    private String student_firstname;
    private String student_lastname;
    private int payment_amount;
    private Date payment_date;
    public paymentData (int student_id, String student_firstname, String student_lastname, int payment_amount, Date payment_date) {
        this.student_id = student_id;
        this.student_firstname = student_firstname;
        this.student_lastname = student_lastname;
        this.payment_amount = payment_amount;
        this.payment_date = payment_date;
    }
    public int getPayment_amount() {
        return payment_amount;
    }
    public Date getPayment_date() {
        return payment_date;
    }
    public String getStudent_firstname() {
        return student_firstname;
    }
    public String getStudent_lastname() {
        return student_lastname;
    }
    public int getStudent_id() {
        return student_id;
    }
}
