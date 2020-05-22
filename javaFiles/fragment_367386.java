@Bean
public ServletWrappingController wrapper() {
   ServletWrappingController  controller = new ServletWrappingController ();
   controller.setServletName("my-servlet");
   controller.setServletClass(CustomerServlet.class);
   return controller;
}

@Bean
public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
    SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
    mapping.setDefaultHandler(wrapper());
    mapping.setOrder(LOWEST_PRECEDENCE  - 2);
    return mapping;
}