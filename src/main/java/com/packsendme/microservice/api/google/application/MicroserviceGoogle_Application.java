package com.packsendme.microservice.api.google.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceGoogle_Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGoogle_Application.class, args);
	}
}

