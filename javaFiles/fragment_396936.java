@Configuration
public class SomeConfig {

    @Bean(name="proxyRestTemplate")
    public RestTemplate proxyRestTemplate() {
        // return a RestTemplate with proxy settings
        return new RestTemplate();
    }


    @Bean(name="nonProxyRestTemplate")
    public RestTemplate nonProxyRestTemplate() {
        // return a RestTemplate without proxy settings
        return new RestTemplate();
    }
}