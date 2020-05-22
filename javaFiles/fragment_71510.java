import main.java.org.example.Config;
import main.java.org.example.GreetingCollector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppContext {
    public static void main(String args[]) {
        System.out.println("Configuring application context...");
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        GreetingCollector collector = (GreetingCollector) context.getBean("greetingCollector");
        System.out.println(collector.getGreeting());
    }
}