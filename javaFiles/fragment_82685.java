public Entity find(DatastoreService datastore,
        String kind, String property, String value)
        throws TooManyResultsException {
    Filter propertyFilter =
        new FilterPredicate(property, FilterOperator.EQUAL, value);

    Query q = new Query(kind).setFilter(propertyFilter);

    return datastore.prepare(q).asSingleEntity();
}