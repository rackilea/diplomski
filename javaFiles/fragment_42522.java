@TestConfiguration
class OAuth2MockMvcConfig {

    @Bean
    public SerializationHelper serializationHelper(ObjectFactory<HttpMessageConverters> messageConverters) {
        return new SerializationHelper(messageConverters);
    }

    @Bean
    public OAuth2MockMvcHelper mockMvcHelper(
            MockMvc mockMvc,
            ObjectFactory<HttpMessageConverters> messageConverters,
            @Value("${controllers.default-media-type:application/json;charset=UTF-8}") MediaType defaultMediaType) {
        return new OAuth2MockMvcHelper(mockMvc, messageConverters, defaultMediaType);
    }

}