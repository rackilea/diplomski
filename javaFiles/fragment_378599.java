public class MyRestTemplateAdapterImpl implements MyRestTemplateAdapter {
    @Autowired
    private RestTemplate    restTemplate;

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    public Object genericPost(String url) {
        // code from above
    }

    public <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables) {
        return restTemplate.postForObject(url, request, responseType);
    }
}