@Configuration
@PropertySource(value="file:config/application.properties")
public class ServiceA implements Condition {

    @Bean
    @Conditional(ServiceA.class)
    public Service service() {
        Service a = ...
        return a; 
    }

    @Override
    public boolean matches(
            ConditionContext conditionContext, 
            AnnotatedTypeMetadata annotatedTypeMetadata) {
        // Will work now
        return conditionContext
                .getEnvironment()
                 .getProperty("service")
                  .equals("ServiceA");
    }    

}