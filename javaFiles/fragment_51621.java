static <T> T[] newArray(T[] reference, int length) {
    Class<?> type = reference.getClass().getComponentType();
    @SuppressWarnings("unchecked")
    T[] result = (T[]) Array.newInstance(type, length);
    return result;
  }