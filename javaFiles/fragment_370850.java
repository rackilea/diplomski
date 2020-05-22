@Autowired
private DispatcherServlet dispatcherServlet;

@Bean
public ServletRegistrationBean servletRegistrationBean() {
    // Necessary so that JSPs don't get handled by the default JspServlet present in the default web.xml
    return new ServletRegistrationBean(dispatcherServlet, "/", "*.jsp");
}