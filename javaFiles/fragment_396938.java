@Component
public class SomeClassWithoutProxy {
    private final RestTemplate restTemplate;

    public SomeClass(@Qualifier("nonProxyRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}