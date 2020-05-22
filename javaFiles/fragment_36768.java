@Configuration
@PropertySource(value = { "my.properties" })
public class MyConfiguration {

    @Value("{prop.value1}")
    private int value1;
    @Value("{prop.value2}")
    private int value2;

    @Bean
    public ExampleBean exampleBean() {
        return new ExampleBean(value1, value2);
    }
}