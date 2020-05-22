TypeConstrainedMappingJackson2HttpMessageConverter messageConverter = 
            new TypeConstrainedMappingJackson2HttpMessageConverter(ResourceSupport.class);
messageConverter.setSupportedMediaTypes(Arrays.asList(MediaTypes.HAL_JSON));

ObjectMapper objectMapper = messageConverter.getObjectMapper();
objectMapper.registerModule(new Jackson2HalModule());
objectMapper.setHandlerInstantiator(
        new Jackson2HalModule.HalHandlerInstantiator(new DefaultRelProvider(), null));

MockMvc mockMvc = MockMvcBuilders.standaloneSetup(testObject)
        .setMessageConverters(messageConverter).build();