package com.breiner.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentApplication {

	//ClassNorFound, update maven project, mask as rot.

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
