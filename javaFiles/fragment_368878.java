@SpringBootApplication
public class Example {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Example.class, args);
        // ...determine it's time to stop...
        int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                // no errors
                return 0;
            }
        });

        // or shortened to
        // int exitCode = SpringApplication.exit(ctx, () -> 0);

        System.exit(exitCode);
    }
}