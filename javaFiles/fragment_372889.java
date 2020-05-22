public Adapter(Gson context, Type elementType,
    TypeAdapter<E> elementTypeAdapter,
    ObjectConstructor<? extends Collection<E>> constructor) {
  this.elementTypeAdapter =
      new TypeAdapterRuntimeTypeWrapper<E>(context, elementTypeAdapter, elementType);
  this.constructor = constructor;
}