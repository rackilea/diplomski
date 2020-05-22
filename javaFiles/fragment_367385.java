@Bean
public ServletForwardingController forwarder() {
   ServletForwardingController controller = new ServletForwardingController();
   controller.setServletName("my-servlet");
   return controller;
}

@Bean
public CustomServlet customServlet() {
    return new CustomServlet();
}

@Bean
public ServletRegistrationBean customServletRegistration() {
    ServletRegistrationBean registration = new ServletRegistrationBean(customServlet(), false);
    registration.setServletName("customServlet");
    return registration;
}

@Bean
public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
    SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
    mapping.setDefaultHandler(forwarder());
    mapping.setOrder(LOWEST_PRECEDENCE  - 2);
    return mapping;
}