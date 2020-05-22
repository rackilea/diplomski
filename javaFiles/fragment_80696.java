@Configuration
public class ActuatorConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public MyHealthEndpoint myHealthEndpoint() {
        return new MyHealthEndpoint();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    @ConditionalOnBean({MyHealthEndpoint.class})
    public MyHealthWebEndpointExtension myHealthWebEndpointExtension(
            MyHealthEndpoint delegate) {
        return new MyHealthWebEndpointExtension(delegate);
    }
}