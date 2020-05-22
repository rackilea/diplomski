@SpringBootApplication
public class Example {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Example.class, args);
        // ...determine it's time to shut down...
        ctx.close();
    }
}