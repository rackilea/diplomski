@Override
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        ByteArrayHttpMessageConverter bahHumbug = new ByteArrayHttpMessageConverter();
        bahHumbug.setSupportedMediaTypes(Collections.singletonList(MediaType.parseMediaType("application/pdf")));
        converters.add(bahHumbug);

        final ObjectMapper objectMapper = 
          Jackson2ObjectMapperBuilder.json()
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .failOnUnknownProperties(true)
            .featuresToEnable(JsonGenerator.Feature.ESCAPE_NON_ASCII)
            .build();       

        converters.add(new MappingJackson2HttpMessageConverter(objectMapper);
        super.configureMessageConverters(converters);
    }