@Component
public class SomeClassWithProxy {
    private final RestTemplate restTemplate;

    public SomeClass(@Qualifier("proxyRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}