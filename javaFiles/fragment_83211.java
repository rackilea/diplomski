package org.hibernate.event.internal;
...
public class DefaultDeleteEventListener implements DeleteEventListener {
    ...
    @Override
    protected void performDetachedEntityDeletionCheck(DeleteEvent event) {
        EventSource source = event.getSession();
        String entityName = event.getEntityName();
        EntityPersister persister = source.getEntityPersister( entityName, event.getObject() );
        Serializable id =  persister.getIdentifier( event.getObject(), source );
        entityName = entityName == null ? source.guessEntityName( event.getObject() ) : entityName; 
        throw new IllegalArgumentException("Removing a detached instance "+ entityName + "#" + id);
    }
    ...
}