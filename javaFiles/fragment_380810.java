@Bean
public CacheManager cacheManager(net.sf.ehcache.CacheManager cacheManager) {
  return new EhCacheCacheManager(cacheManager);
}

@Bean
public EhCacheManagerFactoryBean cacheManagerFactory() {
  EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
  factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
  factoryBean.setShared(true);
  return factoryBean;
}