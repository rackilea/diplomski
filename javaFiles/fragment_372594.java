public List<T> createList(final int n, final Supplier<T> listItemSupplier) {
    final List<T> result = new ArrayList<>(n);
    for (int i = 0; i < n; ++i) {
        result.add(listItemSupplier.get());
    }
    return result;
}
...
createList(5, MyObject::new); // creates a list of 5 MyObjects
createList(3, () -> "hello"); // creates a list of 3 "hello" strings
createList(10, Random::nextLong); // creates a list of 10 random longs