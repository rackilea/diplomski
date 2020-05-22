@Configuration
public class CxfConfig {

@Autowired
private Bus bus;


@Bean
public Server rxServer(){
    final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
    endpoint.setProvider(new JacksonJsonProvider());
    endpoint.setBus(bus);
    endpoint.setAddress("/swagger");
    endpoint.setServiceBeans(Arrays.<Object>asList(contextAPI());
    Swagger2Feature swagger2Feature = new Swagger2Feature();
    endpoint.setFeatures(Arrays.asList(swagger2Feature));
    return endpoint.create();
}


@Bean
public ContextAPI contextAPI(){
    return new ContextAPIImpl();
}