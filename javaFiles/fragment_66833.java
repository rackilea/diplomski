@Configuration
public class Config {

    @Bean
    @ConfigurationProperties(prefix = "amazon.service")
    public Map<String, String> serviceName() {
        return new HashMap<>();
    }
}