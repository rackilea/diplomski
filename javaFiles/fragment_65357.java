public Collection<Integer> getBiggerThan(Collection<Integer> col, int value) {
    // Collection below is an example of one of the rare appropriate 
    // uses of raw types. getClass returns the runtime type of col, and 
    // at runtime all type parameters have been erased.
    @SuppressWarnings("rawtypes")
    final Class<? extends Collection> clazz = col.getClass();
    System.out.println("Input collection type: " + clazz);
    final Supplier<Collection<Integer>> supplier = () -> {
        try {
            return clazz.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(
                    "A checked exception caught inside lambda", e);
        }
    };
    // After all the ugly preparatory code, enjoy the clean pipeline:
    return col.stream()
            .filter(v -> v > value)
            .collect(supplier, Collection::add, Collection::addAll);
}