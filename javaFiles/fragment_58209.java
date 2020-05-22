@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Value("${resources}")
    private String resources;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        if (resources != null) {
            registry.addResourceHandler("/myresources/**").addResourceLocations("file:" + resources);
        }
        super.addResourceHandlers(registry);
    }

}