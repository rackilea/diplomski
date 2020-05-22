protected Object loadFromDatasource(
        final LoadEvent event,
        final EntityPersister persister,
        final EntityKey keyToLoad,
        final LoadEventListener.LoadType options) {
    final SessionImplementor source = event.getSession();
    Object entity = persister.load(
            event.getEntityId(),
            event.getInstanceToLoad(),
            event.getLockMode(),
            source
    );

    if ( event.isAssociationFetch() && source.getFactory().getStatistics().isStatisticsEnabled() ) {
        source.getFactory().getStatisticsImplementor().fetchEntity( event.getEntityClassName() );
    }

    return entity;
}