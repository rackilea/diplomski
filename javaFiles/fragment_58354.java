private final CacheContainer cacheContainer = new CacheContainer();


public Person findById(String id) {
    cacheContainer.getFromCache("personById", id, new CacheLoader<String, Person>() {
        @Override
        public Person load(String key) {
          return findByIdNoCache(key);
      });
}