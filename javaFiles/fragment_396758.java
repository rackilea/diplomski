@Configuration
public class MyWebApplicationInitializer implements ServletContextInitializer  {

    @Override
    public void onStartup(ServletContext sc) {
        FilterRegistration.Dynamic cas20Registration = sc.addFilter("CAS Validation Filter", Cas20ProxyReceivingTicketValidationFilter.class);
        cas20Registration.setInitParameter("casServerUrlPrefix casServerUrlPrefix", "https://casserver/login");
        cas20Registration.setInitParameter("serverName", "http://myapp");
        cas20Registration.setInitParameter("encoding", "UTF-8");
        cas20Registration.addMappingForUrlPatterns(null, false, "/*");
    }
}