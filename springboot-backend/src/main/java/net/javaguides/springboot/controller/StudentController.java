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
    //Student Enter
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    //Get List Student
    @GetMapping
    public ResponseEntity<List<Student>> getALLStudents(){
        return studentService.getAllStudents();
    }
    // Resave  individual Student
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getALLStudentById(@PathVariable Integer studentId){
        return studentService.getStudentById(studentId);
    }
    // Update Student
    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId , @RequestBody Student student){
        return studentService.updateStudent(studentId, student);

    }
    //Student Delete
    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId){
        return studentService.deleteStudent(studentId);
    }
}
