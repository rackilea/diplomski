@EnableWebMvc
@Configuration
@EnableSwagger2
@ComponentScan(basePackages= { "..." })
@PropertySource("...")
public class WebappConfig implements WebMvcConfigurer {

    private ObjectMapper jacksonMapper;

    @Bean(name="jacksonMapper",autowire=Autowire.BY_NAME)
    public ObjectMapper getMapper() {
        return jacksonMapper;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        Iterator<HttpMessageConverter<?>> it = converters.iterator();

        while(it.hasNext()) {
            HttpMessageConverter<?> conv = it.next();

            if(conv instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter jacksonConverter = (MappingJackson2HttpMessageConverter) conv;
                jacksonMapper = jacksonConverter.getObjectMapper();
            }
        }
    }

}