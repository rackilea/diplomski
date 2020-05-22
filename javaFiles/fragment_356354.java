class MyTypeSafeMap {
  private Map<Key<?>, Value<?>> map;
  public <T> void put(Key<T> key, Value<T> value) {
    map.put(key, value); 
  }

  public <T> Value<T> get(Key<T> key) {
    return (Value) map.get(key); 
    // we know it's safe, but the compiler can't prove it
  }
}