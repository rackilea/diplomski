class Bob {
    private final ConcurrentHashMap<String, Jane> instance = new ConcurrentHashMap<>(1);

    public Jane getJane() {
        return instance.computeIfAbsent("KEY", k -> new Jane()); // use whatever constant key
    }
}