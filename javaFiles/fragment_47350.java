package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GsRestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingController.class, args); // <-- modify this line.
    }
}