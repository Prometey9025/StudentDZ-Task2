package com.studentdz.spring.models;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {

    private int studentid;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
    private String name;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 20, message = "Surname should be between 2 and 20 characters")
    private String surname;

    @NotEmpty(message = "Patronymic should not be empty")
    @Size(min = 2, max = 20, message = "Patronymic should be between 2 and 20 characters")
    private String patronymic;

    @NotEmpty(message = "Birthday should not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @NotEmpty(message = "Group should not be empty")
    @Size(min = 2, max = 8, message = "Group should be between 2 and 8 characters")
    private String studentgroup;

    public Student(){

    }

    public Student(String name,String surname,String patronymic, Date birthday,String studentgroup) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.studentgroup = studentgroup;
    }

    public final int getStudentid(){
        return studentid;
    }

    public void setStudentid(int studentid) {this.studentid = studentid;}

    public final String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public final String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public final String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {this.patronymic = patronymic;}

    public final Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public final String getStudentgroup() {
        return studentgroup;
    }

    public void setStudentgroup(String studentgroup) {
        this.studentgroup = studentgroup;
    }



}
