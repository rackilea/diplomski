class CustomHeterogeneousCache {

    private final LoadingCache<Key<?>, List<?>> cache = CacheBuilder.newBuilder()
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .maximumSize(25)
            .build(CacheLoader.from(this::computeEntry));

    @SuppressWarnings("unchecked")
    public <T> List<T> getEntry(Key<T> key) {
        return (List<T>) cache.getUnchecked(key);
    }

    private <T> List<T> computeEntry(Key<T> key) {
        final JoiObjectMapper mapper = new JoiObjectMapper();
        final Collection<File> allConfigFiles = FileUtils.listFiles(new File(key.getIdentifier()), null, true);
        return allConfigFiles.stream()
                .map(configFile -> {
                    try {
                        return mapper.readValue(configFile, key.getTypeReference());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}