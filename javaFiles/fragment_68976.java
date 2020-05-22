@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Autowired
    CustomConfig customConfig;

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/ws/*");
    }
}

@Bean(name = "userA")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema [randomMethodSchema]) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("userAPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://soap.example.com/");
        wsdl11Definition.setSchema([randomMethodSchema]);
        return wsdl11Definition;
    }

@Bean(name = "userB")
    public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema [randomMethodSchema]) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("userBPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://soap.example.com/");
        wsdl11Definition.setSchema([randomMethodSchema]);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema [randomMethodSchema]() {
        return new SimpleXsdSchema(new ClassPathResource([schema name].xsd));
    }
}