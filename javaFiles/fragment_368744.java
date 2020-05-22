void init(Class<E> type) {
  if (type.isAssignableFrom(ConcreteType1.class)) {
    var1 = type.cast(new ConcreteType1(...));
    var2 = type.cast(new ConcreteType1(...));
  } else { /* other branches */ }
}