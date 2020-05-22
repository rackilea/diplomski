public static <K, V> Map.Entry<K, V> getEntryByIndex(Map<K, V> map, int i) {
    if(i >= map.size()) {
        throw new IndexOutOfBoundsException(String.valueOf(i));
    }

    // use Iterator
    Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();

    // skip to i
    for(; i > 0; --i) {
        it.next();
    }

    return it.next();
}