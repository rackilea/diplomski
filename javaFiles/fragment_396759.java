@Bean
public FilterRegistrationBean cas20Registration() {
    FilterRegistrationBean cas20 = new FilterRegistrationBean();
    cas20.setFilter(new Cas20ProxyReceivingTicketValidationFilter());
    cas20.addUrlPatterns("/*");
    cas20.addInitParameter("casServerUrlPrefix casServerUrlPrefix", "https://casserver/login");
    cas20.addInitParameter("serverName", "http://myapp");
    cas20.addInitParameter("encoding", "UTF-8");        
    return cas20;
}