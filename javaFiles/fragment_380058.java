Class<?> entityType = MyClass.class;
ClassMetadata md = sessionFactory.getClassMetadata( entityType );
ScrollableResults scrollableResults = session
        .createCriteria( entityType )
        .setCacheable( false )
        .setFetchSize( 1 )
        .add( Restrictions.gt( md.getIdentifierPropertyName(), checkpointId ))
        .setMaxResults( maxResults )
        .scroll( ScrollMode.FORWARD_ONLY );