@PostConstruct
public void addInterceptors() {
    List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
    interceptors.add(new RestTemplateInterceptor());
    restTemplate.setInterceptors(interceptors);
}