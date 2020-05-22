V replace(K key, V value) {
    V curValue;
    if ((curValue = map.get(key)) != null || map.containsKey(key)) {
        curValue = map.put(key, value);
    }
    return curValue;
} 

V replaceSecond(K key, V value) {
    V curValue = map.get(key); // write
    if (curValue != null || map.containsKey(key)) { // read
        curValue = map.put(key, value); // write
    }
    return curValue;
}