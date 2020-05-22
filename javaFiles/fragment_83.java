@Component
public class CachingSetup implements JCacheManagerCustomizer {

     @Override
     public void customize(CacheManager cacheManager)
     {
       cacheManager.createCache("trans", new MutableConfiguration<>()
         .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(SECONDS, 10)))
         .setStoreByValue(false)
         .setStatisticsEnabled(true));
     }
}