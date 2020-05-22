public Object[] getPropertyValues(Object entity) throws HibernateException {
    boolean getAll = shouldGetAllProperties( entity );
    final int span = entityMetamodel.getPropertySpan();
    final Object[] result = new Object[span];

    for ( int j = 0; j < span; j++ ) {
        StandardProperty property = entityMetamodel.getProperties()[j];
        if ( getAll || !property.isLazy() ) {
            result[j] = getters[j].get( entity );
        }
        else {
            result[j] = LazyPropertyInitializer.UNFETCHED_PROPERTY;
        }
    }
    return result;
}