package com.breiner.school.controller;

import com.breiner.school.client.dto.school.FullSchoolResponse;
import com.breiner.school.entity.School;
import com.breiner.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(School school) {
        schoolService.save(school);

    }

    @GetMapping
    public ResponseEntity<List<School>> findAll() {
        return ResponseEntity.ok(schoolService.findAll());

    }

    @GetMapping("with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllWithStudents(@PathVariable("school-id") Long schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolWithStudents(schoolId));

    }

}
