private static Object getValueOrNull(Supplier<Object> s) {
  try {
    return s.get();
  } catch (Exception e) { //narrow down the exception if possible
    return null;
  }
}