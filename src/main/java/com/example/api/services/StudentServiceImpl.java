package com.example.api.services;

import com.example.api.annotations.DeprecatedClass;
import com.example.api.annotations.InjectRandomInt;
import com.example.api.annotations.PostProxy;
import com.example.api.annotations.Profiling;
import com.example.api.model.Student;
import com.example.api.repos.StudentRepository;
import com.example.api.response.RestApiException;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;


@Profiling
@DeprecatedClass(newImpl = StudentService2.class)
public class StudentServiceImpl implements StudentService {

    @InjectRandomInt(min = 3, max = 20)
    private int randomField;

  //  private final StudentRepository studentRepository;

    private String message;

    public StudentServiceImpl() {
    }

    //  @PostConstruct
    public void init() {
        System.out.println("Phase 2");
        System.out.println(randomField);
    }

    @PostProxy
    public void sayQuote() {
        System.out.println(message);

    }

//    public StudentServiceImpl(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//        System.out.println("Phase 1");
//        System.out.println(randomField);
//    }
//
//
//
//    public List<Student> list() {
//        System.out.println("Random " + randomField);
//        return studentRepository.findAll();
//    }
//
//    public void add(Student student) {
//        if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
//            throw new RestApiException("email is busy");
//        }
//        studentRepository.save(student);
//
//    }
//
//    public void delete(Long studentId) {
//        studentRepository.deleteById(studentId);
//    }
//
//    public void update(Student student) {
//        Optional<Student> row = studentRepository.findById(student.getId());
//
//        if (row.isPresent()) {
//            Student item = row.get();
//
//            if(student.getName() != null && !student.getName().isEmpty()) {
//                item.setName(student.getName());
//            }
//
//            if(student.getDate() != null) {
//                item.setDate(student.getDate());
//            }
//            studentRepository.save(item);
//        }
//
//    }

    public void setRandomField(Integer randomField) {
        this.randomField = randomField;
    }

    public int getRandomField() {
        return randomField;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
