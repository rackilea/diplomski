@Configuration
@PropertySource(value= {"classpath:application.properties"})
public class MyConfig{

    //spring will automatically bind value of property
    @Value("${my.property}")
    private String myProperty;

    //this bean needed to resolve ${property.name} syntax
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}