@Autowire
GenerateLoginToken generateLoginToken;

@Bean
public Endpoint endpointToken() {
    EndpointImpl endpoint = new EndpointImpl(bus, generateLoginToken);



    endpoint.publish("/Token");

    return endpoint;
}