package com.example.api.config;

import com.example.api.model.Student;
import com.example.api.repos.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfigaration {

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {

        return args -> {
            studentRepository.saveAll(List.of(
                    new Student("Alex", "alex@email.com", LocalDate.of(2000, Month.JANUARY, 1)),
                    new Student("John","john@email.com", LocalDate.of(2005, Month.MARCH, 2)),
                    new Student("Mike","mike@email.com", LocalDate.of(2001, Month.FEBRUARY, 8))
            ));
        };
    }
}
