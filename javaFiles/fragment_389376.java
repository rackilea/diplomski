final Entry<K,V> getEntry(Object key) {
    if (size == 0) {
        return null;
    }

    int hash = (key == null) ? 0 : hash(key);
    for (Entry<K,V> e = table[indexFor(hash, table.length)];
         e != null;
         e = e.next) {
        Object k;
        // HERE. Uses == with the key
        if (e.hash == hash &&
            ((k = e.key) == key || (key != null && key.equals(k)))) 
            return e;
    }
    return null;
}