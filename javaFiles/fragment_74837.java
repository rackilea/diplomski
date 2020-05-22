@Component
public class TestRunner implements CommandLineRunner {
    @Value("${bar}")
    private String bar;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void run(String... strings) throws Exception {
        logger.info("Foo from @Value: {}", bar);
        logger.info("Foo from System.getenv(): {}", System.getenv("bar")); // Same output as line above
    }
}