@Log4j2
@Configuration
@PropertySource(value = "classpath:custom.properties", name = "custom-properties")
public class Config {

    @Autowired
    private ConfigurableEnvironment env;

    @Bean
    public Properties customProperties() {

        MutablePropertySources propertySources = env.getPropertySources();
        Properties props = (Properties) propertySources.get("custom-properties").getSource();

        // prints properties
        props.stringPropertyNames().forEach(name -> log.info(name + "=" + env.getProperty(name)));

        // prints unparsed expressions like ${random.value}
        props.entrySet().stream().forEach(e -> log.info(e.getKey() + "=" + e.getValue()));

        // prints property source names
        propertySources.stream().forEach(log::info);

        return props;
    }
}