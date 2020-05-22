@Configuration
public class MyConfiguration {

    @Bean
    public ExampleBean exampleBean() {
        return new ExampleBean(7500000, 42);
    }
}