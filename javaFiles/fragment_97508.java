Serializable entityId = resolveFromCache( event );
if ( entityId != null ) {
    if ( traceEnabled )
        LOG.tracev( "Resolved object in cache: {0}",
                MessageHelper.infoString( persister, event.getNaturalIdValues(), event.getSession().getFactory() ) );
    return entityId;
}

return loadFromDatasource( event );