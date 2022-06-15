package com.example.api.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence")
    private Long id;

    private String name;
    private LocalDate date;
    private int age;

    @Column(unique = true)
    private String email;

    public Student() {

    }
//
//    public Student(String name, LocalDate date) {
//
//        this.name = name;
//        this.date = date;
//    }

    public Student(String name, String email, LocalDate date) {
        this.email = email;
        this.name = name;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAge() {
        return Period.between(date, LocalDate.now()).getYears();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
