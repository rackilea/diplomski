package com.example.demogradleNew;

import com.example.demogradleNew.model.Customer;
import com.example.demogradleNew.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.google.common.collect.Lists;


@SpringBootApplication
@RestController
public class DemogradleNewApplication {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/findAll")
    public List<Customer> findAll() {
        return Lists.newArrayList(repository.findAll());
    }
    @GetMapping("/findByName/{firstName}")
    public List<Customer> findByName(@PathVariable String firstName){
        return repository.findByFirstName(firstName);
    }

    @PostMapping("/saveCustomer")
    public int saveCustomer(@RequestBody List<Customer> customers){
        repository.save(customers);
        return customers.size();
    }


    public static void main(String[] args) {
        SpringApplication.run(DemogradleNewApplication.class, args);
    }

}