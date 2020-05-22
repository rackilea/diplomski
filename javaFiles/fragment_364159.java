public <S, D> TypeMap<S, D> create(S source, Class<S> sourceType, Class<D> destinationType,
      String typeMapName, InheritingConfiguration configuration, MappingEngineImpl engine) {
    synchronized (lock) {
      TypeMapImpl<S, D> typeMap = new TypeMapImpl<S, D>(sourceType, destinationType, typeMapName,
          configuration, engine);
      if (configuration.isImplicitMappingEnabled()
          && ImplicitMappingBuilder.isMatchable(typeMap.getSourceType())
          && ImplicitMappingBuilder.isMatchable(typeMap.getDestinationType()))
        new ImplicitMappingBuilder<S, D>(source, typeMap, config.typeMapStore,
            config.converterStore).build();
      typeMaps.put(TypePair.of(sourceType, destinationType, typeMapName), typeMap);
      return typeMap;
    }
  }