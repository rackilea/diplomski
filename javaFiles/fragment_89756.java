package com;

import com.test.BiPredicateExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
  @Autowired
  BiPredicateExample biPredicateExample;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {
    System.out.println(biPredicateExample.cmp1(10, 2));
    System.out.println(biPredicateExample.getCmp().test(10, 2));
  }
}