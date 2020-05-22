@Configuration
@ComponentScan(basePackages = {"hello", "com.routing.integration"})
@EnableAutoConfiguration
@ImportResource("classpath:camel.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}