public RestTemplate getRestTemplateWithHalMessageConverter() {
 RestTemplate restTemplate = new RestTemplate();
 List<HttpMessageConverter<?>> existingConverters = restTemplate.getMessageConverters();
 List<HttpMessageConverter<?>> newConverters = new ArrayList<>();
 newConverters.add(getHalMessageConverter());
 newConverters.addAll(existingConverters);
 restTemplate.setMessageConverters(newConverters);
 return restTemplate;
}

private HttpMessageConverter getHalMessageConverter() {
 ObjectMapper objectMapper = new ObjectMapper();
 objectMapper.registerModule(new Jackson2HalModule());
 MappingJackson2HttpMessageConverter halConverter = new TypeConstrainedMappingJackson2HttpMessageConverter(ResourceSupport.class);
 halConverter.setSupportedMediaTypes(Arrays.asList(HAL_JSON));
 halConverter.setObjectMapper(objectMapper);
 return halConverter;
}