ServiceLoader<PersistenceProvider> loader = 
        ServiceLoader.load(PersistenceProvider.class);
Iterator<PersistenceProvider> implementations = loader.iterator();
while(implementations.hasNext()) {
    PersistenceProvider implementation = implementations.next();
    logger.info("PersistenceProvider implementation: " + implementation);
}