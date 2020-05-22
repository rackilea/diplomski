private static Cache<String, Integer> c =
   CacheBuilder.newCache(String.class, Integer.class)
     .name("cache")
     .maxSize(1000) // limits in memory cache to 1000 entries
     .expirySecs(60) // sets expiry (time to live) to 60 seconds
     .source(new CacheSource<String, Integer>() {
       public Integer get(String o) {
         System.out.println("ACCESSING SOURCE");
         return checkCache(o) ? 1: 0;
       }
     })
    .build();