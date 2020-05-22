@Override
    public V put(K key, V value) {
    if (key == null) {
      throw new NullPointerException("key == null");
    }

    // my edit here
    if(find(key, false) != null) {
        throw new IllegalArgumentException("'" + key.toString() + "' is duplicate key for json!");
    }

    Node<K, V> created = find(key, true);
    V result = created.value;
    created.value = value;
    return result;
  }