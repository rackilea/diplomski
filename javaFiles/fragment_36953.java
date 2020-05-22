@Bean
FilterRegistrationBean ticketValidationFilter(){

    AbstractTicketValidationFilter ticketValidationFilter = new
            org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter();

    FilterRegistrationBean frb = new FilterRegistrationBean();
    frb.addUrlPatterns("/*");
    frb.setFilter(ticketValidationFilter);

    //here be ticket validaror

    TicketValidator validator = new org.jasig.cas.client.validation.Cas20ServiceTicketValidator("https://localhost:8443/cas");

    ticketValidationFilter.setTicketValidator(validator);

    //end of ticket validator config

    Map<String, String> initParamMap = new HashMap<String, String>();
    initParamMap.put("service", "http://localhost:8889/cas-client");
    frb.setInitParameters(initParamMap);

    return frb;
}