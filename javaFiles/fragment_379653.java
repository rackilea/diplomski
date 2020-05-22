@Configuration
@EnableWs
public class MyWsConfig extends WsConfigurerAdapter {

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        PayloadValidatingInterceptor validatingInterceptor = new PayloadValidatingInterceptor();
        validatingInterceptor.setValidateRequest(true);
        validatingInterceptor.setValidateResponse(true);
        validatingInterceptor.setXsdSchema(yourSchema());
        interceptors.add(validatingInterceptor);
    }

    @Bean
    public XsdSchema yourSchema(){
        return new SimpleXsdSchema(new ClassPathResource("your.xsd"));
    }
    // snip other stuff
}