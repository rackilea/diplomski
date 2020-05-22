package testdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService  customerService;

    @GetMapping(value = "/customers") 
     public Iterable<Customer> findAll() {
       Iterable<Customer> customers = customerService.findAll();
       return customers;
    }
}