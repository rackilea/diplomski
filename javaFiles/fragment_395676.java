@Configuration
public class CustomAutoConfiguration implements EnvironmentAware {

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    // And then accessing via this.environment.getProperty("spring.application.name")

}