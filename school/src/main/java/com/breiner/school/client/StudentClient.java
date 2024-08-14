package com.breiner.school.client;

import com.breiner.school.client.dto.student.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student") // resolve ip and port. si no se espefica la url, feign usa eureka para balancear la carga entre las instancias del servicio(como está registrado el servicio en eureka, debe ser el name))
public interface StudentClient {

    @GetMapping("/api/v1/students/school/{school-id}") //complete
    List<Student> findAllStudentsBySchool(@PathVariable("school-id") Long schoolId);

}
