@Bean
public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() throws IOException {
    PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    MutablePropertySources propertySources = new MutablePropertySources();
    Resource resource = new DefaultResourceLoader().getResource("classpath:application.yml");
    YamlPropertySourceLoader sourceLoader = new YamlPropertySourceLoader();
    PropertySource<?> yamlProperties = sourceLoader.load("yamlProperties", resource, null);
    propertySources.addFirst(yamlProperties);
    configurer.setPropertySources(propertySources);
    return configurer;
}