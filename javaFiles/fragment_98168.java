public static <K, V> Entry<K, V> min(Map<K, V> map, Comparator<V> comp) {
        Iterator<Entry<K, V>> entries = map.entrySet().iterator();
        if (!entries.hasNext()) {
            return null;
        }
        Entry<K, V> min;
        for (min = entries.next(); entries.hasNext();) {
            Entry<K, V> value = entries.next();
            if (comp.compare(value.getValue(), min.getValue()) < 0) {
                min = value;
            }
        }
        return min;
    }