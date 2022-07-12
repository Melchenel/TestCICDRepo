package com.example.api.services;

import com.example.api.repos.StudentRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class StudentService2 extends StudentServiceImpl implements StudentService{

    @Override
    @PostConstruct
    public void sayQuote() {
        System.out.println("Hello 246");
    }


    public void init() {
        System.out.println("Phase 2");

    }

//    public StudentService2(StudentRepository studentRepository) {
//        super(studentRepository);
//    }
}
