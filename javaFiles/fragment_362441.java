package my.spring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MySpringBootApp {
    public static void main(String[] args) {
    SpringApplication.run(new Object[] { MySpringBootApp.class }, args);
   }
}