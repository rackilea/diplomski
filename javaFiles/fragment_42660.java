package test;

import org.springframework.beans.factory.annotation.Autowired;

public class FooService {

    @Autowired
    BlahService blahService;

    public void print() {
        System.out.println("FooService#print: " + blahService.getName());
    }

}