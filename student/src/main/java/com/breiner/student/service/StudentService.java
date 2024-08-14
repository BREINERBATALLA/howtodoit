package com.breiner.student.service;

import com.breiner.student.entity.StudentEntity;
import com.breiner.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void saveStudent(StudentEntity studentEntity) {
        studentRepository.save(studentEntity);
    }

    public List<StudentEntity> findAllStudents() {
        return studentRepository.findAll();
    }

    public List<StudentEntity> findAllStudentsBySchoolId(Long schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
