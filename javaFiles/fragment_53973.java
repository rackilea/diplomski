public class YourApplicationContextInitializer implements ApplicationContextInitializer {

    public void initialize(ConfigurableApplicationContext context) {

        Resource resource = new PathResource(_configFile);
        ConfigurableEnvironment env = context.getEnvironment();
        MutablePropertySources mps = env.getPropertySources();
        mps.addFirst(new ResourcePropertySource("config-file", resource));
    }
}