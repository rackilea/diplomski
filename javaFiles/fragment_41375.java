@Bean
public FilterRegistrationBean springSecurityFilterChainRegistrationBean(@Qualifier("springSecurityFilterChain") Filter filter) {
    FilterRegistrationBean bean = new FilterRegistrationBean();
    bean.setFilter(filter);
    bean.setEnabled(false);
    return bean;
}