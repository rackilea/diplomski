@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main (String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner app(ApplicationContext applicationContext,
                       MessagingService messagingService,
                       Parser parser) {
        return args -> {
            Locale defaultLocale = Locale.getDefault();
            Locale.setDefault(defaultLocale);
            log.info("Using MessagingService: " + messagingService.getMyMessageCode());

            parser.parse();
        };
    }
}