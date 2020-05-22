@Configuration
@EnableWebMvc
@ComponentScan("com.mzk.mavenproject1.controller")
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    ViewResolver internalViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

// ... provide another custom beans when needed
}