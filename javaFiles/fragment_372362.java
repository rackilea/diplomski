@Configuration
@ComponentScan(basePackages = "my.pack.offer.*")
@PropertySource("classpath:OfferService.properties")
public class PropertiesUtil implements EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }

    @Bean
    public String load(String propertyName)
    {
        return environment.getRequiredProperty(propertyName);
    }
}