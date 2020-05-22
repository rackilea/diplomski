public void addAmount(Integer id, Long value) throws Exception {
   Account account = cache.get(id);
   /* what happens if lots of requests come in and another 
      threads evict the account object from the cache? */
   synchronized (account) {
      . . .