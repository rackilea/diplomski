@Bean
public FilterRegistrationBean getPeticionFilter() {

    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new RequestFilter());
    registration.addUrlPatterns("/*");
    registration.setName("requestFilter");

    return registration;
}