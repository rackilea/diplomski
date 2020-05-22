// Configuration class
@EnableWs
@Configuration
public class SpringConfiguration 
{
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) 
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(servlet, "/soap");
    }

    @Bean
    AnnotationActionEndpointMapping annotationActionEndpointMapping() 
    {
        AnnotationActionEndpointMapping mapping = new AnnotationActionEndpointMapping();
        // add any interceptors here for features like logging
        return mapping;
    }

    // wsdl file A
    @Bean(name="wsdl-definition-A")
    public Wsdl11Definition wsdl11DefinitionA()
    {
        SimpleWsdl11Definition def = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("wsdl/A.wsdl"));

        return wsdl11Definition;
    }

    // wsdl file B
    @Bean(name="wsdl-definition-B")
    public Wsdl11Definition wsdl11DefinitionA()
    {
        SimpleWsdl11Definition def = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("wsdl/B.wsdl"));

        return wsdl11Definition;
    }
}