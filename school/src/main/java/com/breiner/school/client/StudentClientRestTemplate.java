package com.breiner.school.client;

import com.breiner.school.client.dto.school.FullSchoolResponse;
import com.breiner.school.client.dto.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
@RequiredArgsConstructor
public class StudentClientRestTemplate {

    private final RestTemplate restTemplate;

    @Value("${services.student-url}")
    private String studentServiceUrl;

    public List<Student> findAllStudentsBySchool(Long schoolId) {
        String url = studentServiceUrl + "/school/{schoolId}";
        ResponseEntity<List<Student>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>() {},
                schoolId
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        throw new RuntimeException("Failed to get students");
    }


}
