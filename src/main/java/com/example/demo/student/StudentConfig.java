package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student bilgehan = new Student(
                    1l,
                    "Bilgehan",
                    LocalDate.of(1994,10,6),
                    "denizlibilgehan@gmail.com"
            );
            Student alex = new Student(
                    "Alex",
                    LocalDate.of(2000,10,10),
                    "alex@gmail.com"
            );
            repository.saveAll(Arrays.asList(bilgehan,alex));
        };
    }
}
