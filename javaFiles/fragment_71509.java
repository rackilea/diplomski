package main.java.org.example;  
import main.java.org.example.GreetingCollector;
import main.java.org.example.Greeting;  
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Greeting greeting() {
        return new Greeting();
    }

    @Bean
    public GreetingCollector greetingCollector(Greeting greeting) {
        return new GreetingCollector(greeting);
    }
}