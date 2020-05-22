@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("http://domain2.com")
        .allowedMethods("PUT", "DELETE")
            .allowedHeaders("header1", "header2", "header3")
        .exposedHeaders("header1", "header2")
        .allowCredentials(false).maxAge(3600);
    }
}