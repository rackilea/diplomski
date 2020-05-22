@Configuration
public class RestConfiguration {

    @Bean
    public RestTemplate myRestTemplate(HttpMessageConverters customConverters) {
        RestTemplate restTemplate = new RestTemplate();
 restTemplate.setMessageConverters(customConverters.getConverters());
        return restTemplate;
    }

    /*
     * The following custom HttpMessageConverter is injected into myRestTemplate
     * in order to appropriately configure the serialization/deserialization of LocalDate
     * instances into/from strings.
     */
    @Bean
    public HttpMessageConverters customConverters() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());  
     mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        converter.setObjectMapper(mapper);
        return new HttpMessageConverters(converter);
    }

}