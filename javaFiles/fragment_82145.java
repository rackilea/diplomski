@Configuration
@ComponentScan(basePackageClasses = LoadProperties.class)
public static class Config {
    @Bean
    public static PropertyPlaceholderConfigurer props() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        Resource[] resource = new ClassPathResource[] { new ClassPathResource(
                "/EclipseProjectName/src/cluster.properties") };
        ppc.setLocations(resource);
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }  

    @Bean
    public LoadProperties loadProperties() {
        return new LoadProperties();
    }
}

public static class LoadProperties {
    private @Value("${cluster.zooServers}") String zooServers;
    ... // getters and setters
}

public static void main(String[] args) throws Exception {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    LoadProperties load = (LoadProperties) context.getBean(LoadProperties.class);
    System.out.println(load.getZooServers());
}