package greeting.example;

import io.micronaut.runtime.Micronaut;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        Micronaut.run(Application.class);
    }

    @Bean
    Function<String, String> stringService(){
        return (value) -> "Test : "+ value;
    }
}