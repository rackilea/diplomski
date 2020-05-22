static <K, E, L extends List<E>> void(Map<K, L> m) {
    for(K key : m.keySet()) {
        L list = m.get(key);
        for(E element : list) {
            // ...
        }
    }
}