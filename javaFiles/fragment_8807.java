package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
public class WS {

    @Autowired
    private lineeRepository repository;

    @RequestMapping(value = "lines", method = RequestMethod.GET)
    public List<String> getIDlinee() {
        return repository.getIDlinea();
    }
}