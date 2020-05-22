Cache<String, List<String>> cachedXpaths = CacheBuilder.newBuilder()
                .expireAfterWrite(3, TimeUnit.MINUTES)
                .maximumSize(1000)
                .concurrencyLevel(5)
                .weakKeys()
                .build(
                        new CacheLoader<String, List<String>>() {
              // Call load method when there is a new key
                            public List<String> load(String key) 
                              throws Exception {
                                // Sample custom method to add a new key 
                                return createListByKey(key);
                            }
                        });