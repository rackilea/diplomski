package com.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class Application {

    public static void main(String[] args) {
        SpringApplicationBuilder parentBuilder 
                = new SpringApplicationBuilder(ApplicationConfiguration.class);
        parentBuilder.child(ServiceOneConfiguration.class)
                .properties("server.port:8080").run(args);
        parentBuilder.child(ServiceTwoConfiguration.class)
                .properties("server.port:8081").run(args);      
    }

    @Configuration
    static class ApplicationConfiguration {

        @Bean
        public MySharedService sharedService() {
            return new MySharedService();

        }   
    }

    @Configuration
    @EnableAutoConfiguration
    static class ServiceOneConfiguration {

        @Bean
        public ControllerOne controller(MySharedService service) {
            return new ControllerOne(service);
        }
    }

    @Configuration
    @EnableAutoConfiguration
    static class ServiceTwoConfiguration {

        @Bean
        public ControllerTwo controller(MySharedService service) {
            return new ControllerTwo(service);
        }
    }

    @RequestMapping("/one")
    static class ControllerOne {

        private final MySharedService service;

        public ControllerOne(MySharedService service) {
            this.service = service;
        }

        @RequestMapping
        @ResponseBody
        public String getMessage() {
            return "ControllerOne says \"" + this.service.getMessage() + "\"";
        }
    }

    @RequestMapping("/two")
    static class ControllerTwo {

        private final MySharedService service;

        public ControllerTwo(MySharedService service) {
            this.service = service;
        }

        @RequestMapping
        @ResponseBody
        public String getMessage() {
            return "ControllerTwo says \"" + this.service.getMessage() + "\"";
        }
    }

   static class MySharedService {

        public String getMessage() {
            return "Hello";
        }
    }
}