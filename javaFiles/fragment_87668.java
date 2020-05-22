private static final LoadingCache<A, B> CACHE = CacheBuilder.newBuilder()
   .maximumSize(100) // if necessary
   .build(
       new CacheLoader<A, B>() {
         public B load(A key) {
           return buildB(key);
         }
       });