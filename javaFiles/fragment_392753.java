class BiDirMap<K,V> extends HashMap<K, V>{

    Map<V,K> reversedMap = new HashMap<V,K>();

    @Override
    public V put(K key, V value) {
        // TODO Auto-generated method stub
        reversedMap.put(value, key);
        return super.put(key, value);
    }

    public K getKeyFromValue(V value){
        return reversedMap.get(value);
    }
}