@Configuration
@EnableAutoConfiguration
@ComponentScan("test.builder")
public class BootApp implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(BootApp.class);

    @Autowired
    private BuilderRepository repository;

    @Override
    public void run(String... args) { 
        Builder builder = repository.findOne(10);    
        logger.info("Retrieved ", builder.toString());
    }

    public static void main(String[] args) {

        SpringApplication.run(BootApp.class, args);

    }

}