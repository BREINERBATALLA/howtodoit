package com.breiner.student.controller;

import com.breiner.student.entity.StudentEntity;
import com.breiner.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save (@RequestBody StudentEntity studentEntity) {
        studentService.saveStudent(studentEntity);
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> findAll () {
       return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<StudentEntity>> findAllStudentsBySchoolId (@PathVariable(value = "school-id") Long schoolId) {
        return ResponseEntity.ok(studentService.findAllStudentsBySchoolId(schoolId));
    }
}
