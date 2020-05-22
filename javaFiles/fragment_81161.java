@Import({})// you can import more configuration classes here
public class CitrusConfiguration {

    @Value("${inbound.service.url}")
    private String serviceUrl;
    @Value("${external.api.mock.port}")
    private int externalApiMockPort;

    @Bean
    public HttpClient inboundClient() {
        return CitrusEndpoints.http()
                .client()
                .requestUrl("http://" + serviceUrl)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .build();
    }

    @Bean
    public HttpServer externalApiMock() {
        return CitrusEndpoints.http()
                .server()
                .port(externalApiMockPort)
                .autoStart(true)
                .timeout(10000)
                .build();
    }
}