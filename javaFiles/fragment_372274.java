@Configuration
public class MyConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "company")
    public Company company() {
        return new Company();
    }
}