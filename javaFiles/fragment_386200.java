package com.in28minutes.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
@ComponentScan("com.in28minutes.springboot")
public class StudentServicesApplication {

public static void main(String[] args) {
    SpringApplication.run(StudentServicesApplication.class, args);
    }

}