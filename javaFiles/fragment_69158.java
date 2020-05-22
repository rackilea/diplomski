@SpringBootApplication
public class MyApplication implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder()
            .listeners(new MyApplication())
            .sources(MyApplication.class)
            .run(args);
    }

    @Override
    public void onApplicationEvent(final ApplicationEnvironmentPreparedEvent event) {
        if (event.getEnvironment().getActiveProfiles().length == 0) {
            LOGGER.error("No active profile is set. Will terminate");
            System.exit(1);
        }
    }
}