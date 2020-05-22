HttpMessageConverter<Object> jackson = new MappingJackson2HttpMessageConverter();
HttpMessageConverter<Resource> resource = new ResourceHttpMessageConverter();
FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
formHttpMessageConverter.addPartConverter(jackson);
formHttpMessageConverter.addPartConverter(resource); // This is hope driven programming

RestTemplate restTemplate = new RestTemplate(Arrays.asList(jackson, resource, formHttpMessageConverter));