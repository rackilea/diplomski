public <K> void add(K obj, Class<? super K> type) {
    HashMap<K, K> toModify = getHashMap(type);
    toModify.put(obj, obj);
}

public void add(Object obj) {
    add(obj, obj.getClass());
}