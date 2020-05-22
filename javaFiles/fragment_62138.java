@EnableWebMvc
@Configuration
@ComponentScan({ "com.yourorg.app" })
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(
        List<HttpMessageConverter<?>> converters) {
        messageConverters.add(new createJsonHttpMessageConverter()); 
        super.configureMessageConverters(converters);
    }

    private HttpMessageConverter<Object> createJsonHttpMessageConverter() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));

        MappingJackson2HttpMessageConverter jsonConverter = 
           new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(objectMapper);

        return jsonConverter;
    }
}