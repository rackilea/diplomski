@SpringBootApplication
public class ProfilesApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(ProfilesApplication.class);

    @Autowired
    private String profiledString;

    public static void main(String[] args) {
        SpringApplication.run(ProfilesApplication.class, args);
    }

    @Bean
    @Profile("PROD")
    public String prodString() {
        return new String("PROD");
    }

    @Bean
    @Profile("TEST")
    public String testString() {
        return new String("TEST");
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("The String in the context is: {}", profiledString);
    }
}