@Bean
public FilterRegistrationBean hiddenHttpMethodFilterRegistration(
        HiddenHttpMethodFilter filter) {
    FilterRegistrationBean registration = new FilterRegistrationBean(filter);
    registration.setFilter(filter);
    registration.addUrlPatterns("/test/*");
    return registration;
}