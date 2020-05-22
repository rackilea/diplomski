Expiry expiry = new Expiry() {
  @Override
  public Duration getExpiryForCreation(Object key, Object value) {
    long msUntilMidnight = LocalTime.now().until(LocalTime.MAX, ChronoUnit.MILLIS);
    return Duration.of(msUntilMidnight, TimeUnit.MILLISECONDS);
  }

  @Override
  public Duration getExpiryForAccess(Object key, ValueSupplier value) {
    return null;
  }

  @Override
  public Duration getExpiryForUpdate(Object key, ValueSupplier oldValue, Object newValue) {
    return null;
  }
};

try(CacheManager cm = CacheManagerBuilder.newCacheManagerBuilder()
  .withCache("cache",
    CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, String.class,
      ResourcePoolsBuilder.newResourcePoolsBuilder()
        .heap(10))
  .withExpiry(expiry))
      .build(true)) {

  // ...
}