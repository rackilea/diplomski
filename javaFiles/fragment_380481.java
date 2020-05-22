public class MyApplication extends Application<MyConfiguration> {
    // [...]
    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                                                   new EnvironmentVariableSubstitutor()
                )
        );

    }

    // [...]
}