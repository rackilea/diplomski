Map<K, V> map = null;
synchronized(hashTable) {
  map = new java.util.HashMap<>(hashTable);
}
map.size();
for(V v: map.values()) {
  //...
}