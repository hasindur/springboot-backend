package net.javaguides.springboot.service;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dao.StudentDao;
import net.javaguides.springboot.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
