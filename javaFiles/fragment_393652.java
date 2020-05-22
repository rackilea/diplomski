class ResultFactory {
    private static final Map<CreationParams, Supplier<Result>> factories = createFactoryMap();

    private static Map<CreationParams, Supplier<Result>> createFactoryMap() {
        final Map<CreationParams, Supplier<Result>> result = new HashMap<>();
        result.put(new CreationParams(0, 0), FirstResult::new);
        result.put(new CreationParams(0, 1), SecondResult::new);
        // ...
        return result;
    }

    Result createResult(int foo, int bar) {
        return factories.get(new CreationParams(foo, bar)).get();
    }
}