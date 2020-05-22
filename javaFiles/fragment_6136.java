@Bean
public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    List<Resource> resources = new LinkedList<Resource>();
    resources.add(new ClassPathResource("config.properties"));
    resources.add(new ClassPathResource("config2.properties"));
    configurer.setLocations(resources.toArray(new Resource[0]));
    configurer.setIgnoreUnresolvablePlaceholders(true);
    return configurer;

}