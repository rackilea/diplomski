@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

@Bean
public MappingJackson2HttpMessageConverter    customJackson2HttpMessageConverter() {
   MappingJackson2HttpMessageConverter jsonConverter = new           MappingJackson2HttpMessageConverter();
   ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  jsonConverter.setObjectMapper(objectMapper);
  return jsonConverter;
 }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>>   converters) {
  converters.add(customJackson2HttpMessageConverter());
 super.addDefaultHttpMessageConverters();
}
  }