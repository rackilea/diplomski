@Configuration
@EnableWebMvc
@Import({
        EndpointAutoConfiguration.class , PublicMetricsAutoConfiguration.class , HealthIndicatorAutoConfiguration.class
})
public class MyActuatorConfig {

    @Bean
    @Autowired
    public EndpointHandlerMapping endpointHandlerMapping(Collection<? extends MvcEndpoint> endpoints) {
        return new EndpointHandlerMapping(endpoints);
    }

    @Bean
    @Autowired
    public EndpointMvcAdapter metricsEndPoint(MetricsEndpoint delegate) {
        return new EndpointMvcAdapter(delegate);
    }
}