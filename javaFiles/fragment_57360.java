@Configuration
@Profile("production")
public class ProductionConfig {
    @Bean 
    public SomeService someService() { ... }
}

@Configuration
@Profile("dev")
public class DevelopmentConfig {
    @Bean 
    public SomeService someService() { ... }
}