@Component
class WebConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/mockups/**").addResourceLocations("/src/main/resources/templates/mockups/");
   }
}