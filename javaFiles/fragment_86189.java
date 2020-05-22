static @Bean
public PropertySourcesPlaceholderConfigurer myPropertySourcesPlaceholderConfigurer() {
    PropertySourcesPlaceholderConfigurer p 
        = new PropertySourcesPlaceholderConfigurer();
    org.springframework.core.io.Resource[] resourceLocations 
        = new org.springframework.core.io.Resource[] {
            new ClassPathResource("application.properties")
    };
    p.setLocations(resourceLocations);
    return p;
}