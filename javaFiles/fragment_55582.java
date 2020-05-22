@Bean
public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
    propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("test.properties"));
    return propertySourcesPlaceholderConfigurer;
}