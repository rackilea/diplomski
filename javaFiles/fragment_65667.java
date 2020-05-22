ObjectMapper mapper = new ObjectMapper();
mapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
mapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);


MappingJacksonHttpMessageConverter messageConverter = new MappingJacksonHttpMessageConverter();
messageConverter.setObjectMapper(mapper);
List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
messageConverters.add(messageConverter);
RestTemplate restTemplate = new RestTemplate();
restTemplate.setMessageConverters(messageConverters);