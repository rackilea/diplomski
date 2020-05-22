new CacheLoader<String, DataBuilder>() {
    @Override
    public DataBuilder load(String key) throws Exception {
        return callSomeMethodToBuildItFromTheKey(key); // could be new DataBuilder(key)
    }
}