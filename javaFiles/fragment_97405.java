LoadingCache<Key,Foo> cache = CacheBuilder.newBuilder().
  concurrencyLevel(32).
  build(new CacheLoader<Key,Foo>() {
    public Foo load(Key key) {
      return createFooExpensively(key);
    }
  });

...
Foo result = cache.get(key);