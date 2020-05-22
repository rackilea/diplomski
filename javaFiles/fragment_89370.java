@Bean
    RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    // move XML converter to the end of list
    List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
    for (int i = 0; i < messageConverters.size() -1 ; i++) {
        if (messageConverters.get(i) instanceof MappingJackson2XmlHttpMessageConverter) {
            Collections.swap(messageConverters, i,messageConverters.size() - 1);
        }
    }

    restTemplate.setMessageConverters(messageConverters);

    // add interceptors if necessary
    restTemplate.setInterceptors(Collections.singletonList(catalogInterceptior()));
    return restTemplate;
}