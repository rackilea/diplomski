@SpringBootApplication
@EnableBatchProcessing
@Import(CoreCommonsAppComponent.class)
public class Application {
    // a lot of nice things

    public static void main(String... args) throws Exception{
        ApplicationContext context = SpringApplication.run(Application.class, args);
        logger.info("================================================");
        SpringApplication.exit(context);
        System.exit(SingletonExitCode.getInstance().exitCode.getCode());
    }
}