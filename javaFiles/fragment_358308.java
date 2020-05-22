@Override
public void integrate(Metadata metadata, SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {

    EventListenerRegistry listenerRegistry = serviceRegistry.getService( EventListenerRegistry.class );
    listenerRegistry.addDuplicationStrategy( EnversListenerDuplicationStrategy.INSTANCE );  

    EnversService enversService = serviceRegistry.getService(EnversService.class);
    if (!enversService.isInitialized()) {
        throw new HibernateException("Expecting EnversService to have been initialized prior to call to EnversIntegrator#integrate");
    }
    if(enversService.getEntitiesConfigurations().hasAuditedEntities()) {
        listenerRegistry.appendListeners( EventType.POST_UPDATE, new PostUpdateListenerLog( enversService ) );
        listenerRegistry.appendListeners( EventType.POST_INSERT, new PostInsertListenerLog( enversService ) );
        listenerRegistry.appendListeners( EventType.POST_DELETE, new PostDeleteListenerLog( enversService ) );
    }
}