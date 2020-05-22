static <T> T findInList(List<?> list, Class<T> clazz) {
  for (Object o : list) {
    if (clazz.isInstance(o)) {
      return clazz.cast(o);
    }
  }
  return null;
}