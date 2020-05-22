class MapWrapper<K, V> {
  MultiMap<String, K> metadata = hazelcastInstance.getMultiMap("metadata");

  Cluster cluster = hazelcastInstance.getCluster();
  Member localMember = cluster.getLocalMember();
  String uuid = localMember.getUuid();

  IMap<K, V> realMap = hazelcastInstance.getMap("...");

  public void putWrapper(K key, V value) {
    realMap.put(key, value);
    metadata.put(uuid, key);
  }
}