@Configuration
@ConditionalOnClass(ObjectMapper.class)
public class SquigglyAutoconfigure {

@Bean
public FilterRegistrationBean squigglyRequestFilter(ObjectMapper objectMapper) {
        Squiggly.init(objectMapper, new RequestSquigglyContextProvider());

        FilterRegistrationBean<SquigglyRequestFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new SquigglyRequestFilter());
        filter.setOrder(1);
        return filter;
    }
}