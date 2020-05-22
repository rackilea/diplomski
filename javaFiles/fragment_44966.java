public static <T, V> Splitter<T, V> getSplitter(Class<T> key1, Class<V> key2) {

    if (key1 == Company.class && key2 == Department.class)
        return (Splitter<T, V>) new CompanySplitterImpl();

    // more cases
}