public static <V> HashSet<HashSet<V>> getCombos(HashSet<V> base, HashSet<V> elements, int size) {
    HashSet<HashSet<V>> combos = new HashSet<HashSet<V>>();
    HashSet<V> inner = dupe(base);
    inner.removeAll(elements);
    recur(elements, combos, inner, size);
    return combos;

}

public static <V> HashSet<V> dupe(HashSet<V> orig) {
    return new HashSet<V>(orig);
}

public static <V> void recur(HashSet<V> curr, HashSet<HashSet<V>> combos, HashSet<V> base, int size) {
    if (curr.size() == size) {
        combos.add(dupe(curr));
    } else {
        HashSet<V> inner = dupe(base);
        for (V v : base) {
            inner.remove(v);
            curr.add(v);
            recur(curr, combos, inner, size);
            curr.remove(v);
        }
    }
}