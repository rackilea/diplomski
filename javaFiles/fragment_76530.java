@ComponentScan(basePackageClasses = {
        MongoService.class,
        AppProperties.class
})
@SpringBootApplication
public class TestConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(TestConfiguration.class, args);
    }
}