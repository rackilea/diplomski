private final Supplier<List<Something>> cache =
    Suppliers.memoizeWithExpiration(new Supplier<List<Something>>() {
        public List<Something> get() {
            return loadFromDb();
        }
    }, 2, MINUTES);

private List<Something> loadFromDbCached() {
    return cache.get();
}