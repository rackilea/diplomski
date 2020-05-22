class ObliviousClass {

  private final Map<Key, Object> map = new HashMap<Key, Object>();

  public Object put(Key key, Object value)
  {
    return map.put(key, value);
  }

  public <T> T get(Key key, Class<? extends T> type)
  {
    return type.cast(map.get(key)); 
  }

}