@Configuration
public class MorphiaAutoConfiguration {

    @Autowired
    private MongoClient mongoClient; // created from MongoAutoConfiguration

    @Bean
    public Datastore datastore() {
        Morphia morphia = new Morphia();

        // map entities, there is maybe a better way to find and map all entities
        ClassPathScanningCandidateComponentProvider entityScanner = new ClassPathScanningCandidateComponentProvider(true);
        entityScanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
        for (BeanDefinition candidate : scanner.findCandidateComponents("your.basepackage")) { // from properties?
            morphia.map(Class.forName(candidate.getBeanClassName()));
        }

        return morphia.createDatastore(mongoClient, "dataStoreInstanceId"); // "dataStoreInstanceId" may come from properties?
    }
}