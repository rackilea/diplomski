@Configuration
@PropertySource(value="classpath:your_file.properties")
public class MyConfiguration{

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()    {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
    return p;
    }
}