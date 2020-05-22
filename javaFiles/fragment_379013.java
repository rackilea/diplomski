@Configuration
@EnableWs
public class MyWebServiceConfiguration extends WsConfigurerAdapter {
    @Bean(name = "marshaller")
    public Jaxb2Marshaller createJaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        return marshaller;
    }

    @Autowired
    private MyEndpointInterceptor myEndpointInterceptor;

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors)
    {
        // Register interceptor
        interceptors.add(myEndpointInterceptor);
    }
}