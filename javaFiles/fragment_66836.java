@Configuration
public class Config {

    @Bean
    @ConfigurationProperties(prefix = "amazon.service")
    public Pojo serviceName() {
        return new Pojo();
    }
}