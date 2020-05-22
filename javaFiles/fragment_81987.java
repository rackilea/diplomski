@Bean
public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
    p.setLocation(new ClassPathResource("your properties path"));
    // other properties
    return p;
}