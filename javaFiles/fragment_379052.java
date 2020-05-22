@Configuration
@ConditionalOnClass({ CouchbaseOperations.class, Bucket.class })
//@ConditionalOnBean(CouchbaseOperations.class)
@ConditionalOnEnabledHealthIndicator("couchbase")
public class CouchbaseHealthConfig extends CompositeHealthIndicatorConfiguration<CouchbaseHealthIndicator, CouchbaseOperations>
{
    private final Map<String, CouchbaseOperations> couchbaseOperations;

    public CouchbaseHealthConfig(Map<String, CouchbaseOperations> couchbaseOperations)
    {
        this.couchbaseOperations = couchbaseOperations;
    }

    @Bean
    @ConditionalOnMissingBean(name = "couchbaseHealthIndicator")
    public HealthIndicator couchbaseHealthIndicator()
    {
        return createHealthIndicator(this.couchbaseOperations);
    }
}