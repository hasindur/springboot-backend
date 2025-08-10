package net.javaguides.springboot.service;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dao.StudentDao;
import net.javaguides.springboot.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDao studentDao;

    public ResponseEntity<Student> saveStudent(Student student) {

        student = studentDao.save(student);

        if (student.getStudentId() == null){
            throw new RuntimeException("Student Save Fail");
        }else {
            return ResponseEntity.ok(student);
        }
    }

    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentDao.findAll();
        return ResponseEntity.ok(studentList);
    }

    public ResponseEntity<Student> getStudentById(Integer studentId) {
        if (studentId == null) {
            throw new RuntimeException("Student ID cannot be null");
        }else {
            Optional<Student> optionalStudent = studentDao.findById(Long.valueOf(studentId));
            if (optionalStudent.isPresent()){
                return ResponseEntity.ok(optionalStudent.get());
            } else {
                throw new RuntimeException("Student not found with ID: " + studentId);
            }
        }
    }
}
