void updateWeight(int delta) {
        weight += delta;
        Entry<K, V> p = parent;
        while (p != null) {
            p.weight += delta;
            p = p.parent;
        }
    }