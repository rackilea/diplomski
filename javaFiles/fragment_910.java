@Configuration
    @EnableWebMvc
    @ComponentScan(basePackages =     
     {"spring.ahmed.mostafa.data","com.ahmed.mostafa.controllers"})
    @EnableFilesystemStores("com.ahmed.mostafa.controllers")
    @Import(org.springframework.content.rest.config.RestConfiguration.class)
    public class SpringWebConfig implements WebMvcConfigurer {