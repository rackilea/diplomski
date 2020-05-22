@Configuration
class HealthConfig {
    @Bean
    HealthEndpoint healthEndpoint(Map<String, HealthIndicator> defaultIndicators){
        for(int i=0;i<10;i+=1){
            defaultIndicators.put("custom_indicator_" + i, ()-> Health.down().build());
        }
        return new HealthEndpoint(new OrderedHealthAggregator(), defaultIndicators);
    }
}