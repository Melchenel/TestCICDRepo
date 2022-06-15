package com.example.api.services;

import com.example.api.model.Student;
import com.example.api.repos.StudentRepository;
import com.example.api.response.RestApiException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> list() {
        return studentRepository.findAll();
    }

    public void add(Student student) {
        if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            throw new RestApiException("email is busy");
        }
        studentRepository.save(student);
    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void update(Student student) {
        Optional<Student> row = studentRepository.findById(student.getId());

        if (row.isPresent()) {
            Student item = row.get();

            if(student.getName() != null && !student.getName().isEmpty()) {
                item.setName(student.getName());
            }

            if(student.getDate() != null) {
                item.setDate(student.getDate());
            }
            studentRepository.save(item);
        }

    }
}
