@Configuration
public class MethodValidationConfig {
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MyMethodValidationPostProcessor();
    }
}