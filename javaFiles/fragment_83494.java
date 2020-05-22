@SpringBootApplication
public class Main {
    public static void main(String... args) {
        SpringApplication app = new SpringApplication(Main.class);
        app.setRegisterShutdownHook(true);
        app.run(args);
    }
}