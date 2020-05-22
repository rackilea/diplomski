public static <K,V> V mapGet(Map<K, V> map, K key, V defaultValue) {
    V ret = map.get(key);
    if (ret == null) {
        return defaultValue;
    }
    return ret;
}