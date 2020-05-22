@Configuration
class GemFireConfiguration {

  @Bean
  MyCustomExpiry customTimeToLiveExpiration() {
    return new MyCustomExpiry();
  }

  @Bean("Example")
  PartitionedRegionFactoryBean<String, Object> exampleRegion(
      GemFireCache gemfireCache) {

    PartitionedRegionFactoryBean<String, Object> exampleRegion =
      new PartitionedRegionFactoryBean<>();

    exampleRegion.setCache(gemfireCache);
    exampleRegion.setClose(false);
    exampleRegion.setPersistent(false);
    exampleRegion.setCustomEntryTimeToLive(customTimeToLiveExpiration());
    exampleRegion.setCustomEntryIdleTimeout(new MyCustomExpiry());

    return exampleRegion;
  }
}