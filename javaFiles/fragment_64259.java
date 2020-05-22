@Configuration
public class AppConfig  implements EnvironmentAware {

    Environment env;

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        Properties properties = Utils.getProperties(new File(env.getProperty("credential")));
        properties.setProperty("startDate",env.getProperty("startDate"));
        propertySourcesPlaceholderConfigurer.setProperties(properties);
        propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        propertySourcesPlaceholderConfigurer.setIgnoreResourceNotFound(true);
        return propertySourcesPlaceholderConfigurer;
    }

    @Override
    public void setEnvironment(Environment environment) {
        env = environment;
    }
}