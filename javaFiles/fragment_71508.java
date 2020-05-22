/* Bean definition

@Component tells Spring that this is a bean. There are a few similar annotations.
It will be discovered during the component scan, as it has @Component annotation */

package main.java.org.example;
import org.springframework.stereotype.Component;

@Component 
public class Greeting {
    private String greeting = "Hello";

    public String getGreeting() {
        return this.greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}


/* Another bean definition.
It has another bean as a dependency, which we inject with a setter. */

package main.java.org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingCollector {
    private Greeting greeting;

    /* This is how you do setter injection */
    @Autowired
    public void setGreeting(Greeting greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting.getGreeting();
    }
}


/* This is a minimal config class. 
@ComponentScan instructs to look for classes that are 
annotated with @Component annotation (in other words, beans) */

package main.java.org.example;    
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Config {}