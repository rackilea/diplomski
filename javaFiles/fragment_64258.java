@SpringBootApplication
@Slf4j
public class AppRunner implements CommandLineRunner {

    public static void main(String[] args) throws IOException {
        System.setProperty("spring.config.additional-location","path\\credentials.properties");
        SpringApplication.run(AppRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ...
    }
}