//the test configuration
@Configuration
@Profile("test")
public class WebConfig {
    @Bean
    RestTemplate restTemplate() {
        return TraceableRestTemplate.create();
    }
}