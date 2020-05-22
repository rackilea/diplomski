public int keyIndex(K key) {
    if (key == null) {
        throw new NullPointerException();
    }
    Entry<K, V> e = getEntry(key);
    if (e == null) {
        throw new NullPointerException();
    }
    if (e == root) {
        return getWeight(e) - getWeight(e.right) - 1;//index to return
    }
    int index = 0;
    int cmp;
    index += getWeight(e.left);

    Entry<K, V> p = e.parent;
    // split comparator and comparable paths
    Comparator<? super K> cpr = comparator;
    if (cpr != null) {
        while (p != null) {
            cmp = cpr.compare(key, p.key);
            if (cmp > 0) {
                index += getWeight(p.left) + 1;
            }
            p = p.parent;
        }
    } else {
        Comparable<? super K> k = (Comparable<? super K>) key;
        while (p != null) {
            if (k.compareTo(p.key) > 0) {
                index += getWeight(p.left) + 1;
            }
            p = p.parent;
        }
    }
    return index;
}