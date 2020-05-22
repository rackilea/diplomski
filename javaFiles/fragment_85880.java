@Configuration
@Profile("local")
public class LocalPropertyReader {

    @Bean
    public static PropertyPlaceholderConfigurer properties() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[] {
            new ClassPathResource("docker-db.properties"), new ClassPathResource("application-local.properties")
        };
        ppc.setLocations(resources);
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }
}



@Configuration
@Profile("test")
public class ProdPropertyReader {


    @Bean
    public static PropertyPlaceholderConfigurer properties() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[] {
            new ClassPathResource("test-db.properties"), new ClassPathResource("application-test.properties")
        };
        ppc.setLocations(resources);
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }
}