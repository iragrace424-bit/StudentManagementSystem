package com.example.studentmanagement.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.studentmanagement.service.StudentService;
import org.springframework.stereotype.Controller;
import com.example.studentmanagement.model.Student;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    // Constructor-based Dependency Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }
    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/student/all";
    }
    @GetMapping("/all")
    public String showAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
}