public V getExampleThree(K key) {
    Object o = new Object();
    map.putIfAbsent(key, o);
    Object ret = map.get(key);
    return ret == null ? o : ret;
}