public static <K, V> Multimap<K, V> indexMutable(Iterable<V> values,
        Function<? super V, K> function) {

    // check null value, function
    Multimap<K, V> map = ArrayListMultimap.create();

    for (V v : values) {
        // check null V
        map.put(function.apply(v), v);
    }

    return map;
}