@SpringBootApplication
public class RestApiApplication implements CommandLineRunner {

    @Autowired
    private TaskScheduler ts;

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ts.<your-code>
    }