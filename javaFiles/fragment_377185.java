@EnableConfigurationProperties({
    CouchbaseContext.class
})
@Configuration
public class CouchbaseConfig {

    @Bean
    public Bucket bucket(CouchbaseContext couchbaseContext) { ... }
}