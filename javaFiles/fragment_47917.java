@Configuration
@EnableWebMvc 
public class MvcConfig implements WebMvcConfigurer { 
    @Override 
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**") // your prefered mapping, for example web app root
                .addResourceLocations("/resources/"); // project files location
    }
}