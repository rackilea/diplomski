public AccountServiceImpl() {
    cache = CacheBuilder.newBuilder()
        .expireAfterAccess(1, TimeUnit.HOURS)
        .concurrencyLevel(4)
        .maximumSize(10000)
        .recordStats()
        .build(new CacheLoader<Integer, Account>() {
            @Override
            public Account load(Integer id) throws Exception {
                return accountDAO.getAmountById(id);
            }
        });
}

Long getAmount(Integer id) {
  return cache.get(id);
} 

void addAmount(Integer id, Long value) {
  accountDAO.addAmount(id, value);
  cache.remove(id);
}