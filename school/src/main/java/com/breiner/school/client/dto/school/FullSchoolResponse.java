package com.breiner.school.client.dto.school;


import com.breiner.school.client.dto.student.Student;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {

    private String name;

    private String email;

    private List<Student> students;
}
