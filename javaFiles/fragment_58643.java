private static class MultisetInstanceCreator implements InstanceCreator<Multiset<?>> {
    @Override
    public Multiset<?> createInstance(Type type) {
        return HashMultiset.create();
    }
}

Gson gson = new GsonBuilder()
        .registerTypeAdapter(Multiset.class, new MultisetInstanceCreator())
        .create();