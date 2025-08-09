package net.javaguides.springboot.controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getALLStudents(){
        return studentService.getAllStudents();
    }
}
