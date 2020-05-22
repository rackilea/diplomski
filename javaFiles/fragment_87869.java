@PropertySources({
    @PropertySource(name = AppConfig.FIRST, value = "classpath:first.properties"),
    @PropertySource(name = AppConfig.SECOND, value = "classpath:second.properties")
})    
public class AppConfig {

static final String FIRST = "first";
static final String SECOND = "second";

@Autowired
private AbstractEnvironment defaultConfiguration;

@Bean
public SomeBean someBean {
    //reading from first properties file         
    firstConfiguration().getProperty("someProperty");
    //reading from second properties file
    secondConfiguration().getProperty("someProperty");
}

@Bean
public org.springframework.core.env.PropertySource<?> firstConfiguraiton() {
    return defaultConfiguration.getPropertySources().get(FIRST);
}

@Bean
public org.springframework.core.env.PropertySource<?> secondConfiguration() {
    return defaultConfiguration.getPropertySources().get(SECOND);
}
}