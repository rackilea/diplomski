static Class<?> original(Class<?> type) {
  try {
    type.getDeclaredField("CGLIB$BOUND");
    if (type.getSuperclass() != Object.class) {
      return type.getSuperclass();
    }
    for (Class<?> iFace : type.getInterfaces()) {
      if (iFace != Factory.class) {
        return iFace;
      }
    }
    return Object.class;
  } catch (NoSuchFieldException ignored) {
    return type;
  }
}