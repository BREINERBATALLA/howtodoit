package com.breiner.school.service;

import com.breiner.school.client.StudentClient;
import com.breiner.school.client.StudentClientRestTemplate;
import com.breiner.school.client.dto.school.FullSchoolResponse;
import com.breiner.school.entity.School;
import com.breiner.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;
    private final StudentClientRestTemplate studentClientRestTemplate;

    public void save(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolWithStudents(Long schoolId) {
        //ResTemplateWay
        //return findSchoolWithStudentsRestTemplate(schoolId);

        var school = schoolRepository.findById(schoolId)
                .orElse(new School());

        var students = studentClient.findAllStudentsBySchool(schoolId);

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();

    }

    public FullSchoolResponse findSchoolWithStudentsRestTemplate(Long schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(new School());

        var students = studentClientRestTemplate.findAllStudentsBySchool(schoolId);

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }

}
