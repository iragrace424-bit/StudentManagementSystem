package com.example.studentmanagement.controller;

import com.example.studentmanagement.service.StudentService;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    private final StudentService studentService;

    // Constructor-based Dependency Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}