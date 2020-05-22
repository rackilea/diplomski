private <T> void safePut(
    Map<Class<?>, ValueLoader<?>> map,
    Class<T> clazz,
    ValueLoader<T> valueLoader) {
  map.put(clazz, valueLoader);
}