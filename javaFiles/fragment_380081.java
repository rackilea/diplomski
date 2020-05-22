//the regular configuration not active with test profile
@Configuration
@Profile("!test")
public class WebConfig {
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        //you can use your regular rest template here.
        //This one adds a X-TRACE-ID header from the MDC to the call.
        return TraceableRestTemplate.create();
    }
}