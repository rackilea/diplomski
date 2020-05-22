@Configuration
public class HelloServiceConfig {

    @Bean
    @Scope("prototype")
    public HelloService helloService(@Value("${webservice.endpoint.address}") String endpointAddress) {
        HelloService service = new HelloService();
        Hello port = service.getHelloPort();
        BindingProvider bindingProvider = (BindingProvider) port;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,endpointAddress);
        return service;
    }

}

@Component
public class BusinessService {

     @Autowired
     private HelloService hellowService;
     ...

     public void setHelloService(HelloService helloService) {
        this.helloService = hellowService;
     }
}