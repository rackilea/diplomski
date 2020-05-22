private <S, D> TypeMap<S, D> createTypeMapInternal(S source, Class<S> sourceType,
      Class<D> destinationType, String typeMapName, Configuration configuration) {
    if (source != null)
      sourceType = Types.<S>deProxy(source.getClass());
    Assert.state(config.typeMapStore.get(sourceType, destinationType, typeMapName) == null,
        String.format("A TypeMap already exists for %s and %s", sourceType, destinationType));
    return config.typeMapStore.create(source, sourceType, destinationType, typeMapName,
        (InheritingConfiguration) configuration, engine);
  }