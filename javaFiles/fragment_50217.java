package com.eureka.discovery.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eureka.discovery.client.bo.Employee;

@SpringBootApplication
@RestController
//@EnableDiscoveryClient
public class UserApplication {

  @Bean
//@Loadbalancer
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Autowired
  RestTemplate restTemplate;

  @RequestMapping("/hi")
  public String hi() {
      Employee[] employeeList = this.restTemplate.getForObject("http://localhost:8090/emp-api", Employee[].class);
    return String.format("%s, %s!", "Testing", "Abhay");
  }

  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }
}