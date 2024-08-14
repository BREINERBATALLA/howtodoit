package com.breiner.school.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "schools")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}