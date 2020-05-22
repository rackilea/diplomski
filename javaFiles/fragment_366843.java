@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:9798")
            .allowedMethods("POST", "GET")
            .allowCredentials(true).maxAge(3600);
    }
}