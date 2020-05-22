package com.example.config;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "demo.foo")
public class DemoConfig {
    @NotBlank private String strVal;
    private final ObjVal objVal = new ObjVal();

   // getter & setter for strVal

   // getter for objVal (we already have an instance so we can "crawl to it")

    public static class ObjVal {
        @NotBlank private String objVal;

        // getter & setter for objVal
  }
}