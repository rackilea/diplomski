@Bean
public FilterRegistrationBean securityFilterChain(@Qualifier(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME) Filter securityFilter) {
    FilterRegistrationBean registration = new FilterRegistrationBean(securityFilter);
    registration.setOrder(Integer.MAX_VALUE - 1);
    registration.setName(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME);
    return registration;
}

@Bean
public FilterRegistrationBean userInsertingMdcFilterRegistrationBean() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    UserInsertingMdcFilter userFilter = new UserInsertingMdcFilter();
    registrationBean.setFilter(userFilter);
    registrationBean.setOrder(Integer.MAX_VALUE);
    return registrationBean;
}