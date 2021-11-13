package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity(name = "Student")
@Table(
        name = "Student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique",columnNames = "email")
        })
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id",
            updatable = false
    )
    private Long id;

    @Column(name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(name = "date_of_birth",
            nullable = false
    )
    private LocalDate dob;

    @Column(name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student: " + '\n' +
                "ID = " + id + '\n' +
                "Name = " + name + '\n' +
                "Age = " + age + '\n' +
                "Date of Birth = " + dob + '\n' +
                "EMail = " + email;
    }
}
