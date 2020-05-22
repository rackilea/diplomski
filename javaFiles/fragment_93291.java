@Configuration
public class OptionalWebFiltersConfiguration {

    @Configuration
    @ConditionalForFilterX
    public static class FilterXConfiguration {

        @Bean
        public Filter filterX() {
             return new FilterX();
        }

        @Bean
        public FilterRegistrationBean filterXRegistrationBean() {
             FilterRegistrationBean frb = new FilterRegistrationBean frb = new FilterRegistrationBean(filterX());
             // other config
             return verb;
        }
    }
}