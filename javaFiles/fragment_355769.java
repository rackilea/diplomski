public static <T, C extends Collection<T>> C typesafeAdd(Iterable<?> from, C to, Class<T> listClass) {
    for (Object item: from) {
      to.add(listClass.cast(item));
    }
    return to;
  }