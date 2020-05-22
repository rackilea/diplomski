public class RuntimeEnvironmentInitializer implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {

private ConfigurableWebApplicationContext configurableApplicationContext;

@Override
    public void initialize(ConfigurableWebApplicationContext arg0) {
        this.configurableApplicationContext = arg0;
        String valueString = arg0.getServletContext().getInitParameter("InitParam");
        configurableApplicationContext.getEnvironment().setActiveProfiles("prod");
    }
}