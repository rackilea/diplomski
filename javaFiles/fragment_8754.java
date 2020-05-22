@Bean
public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() throws IOException {
    String profile = System.getProperty("spring.profiles.active");
    PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
    Resource resource = new ClassPathResource(String.format("application-%s.properties", profile));
    Properties props = PropertiesLoaderUtils.loadProperties(resource);
    pspc.setProperties(props);
    pspc.setPropertySources();
    return pspc;
}