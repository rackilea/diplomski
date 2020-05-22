public boolean exists(Key key){
    Query q;
    if (key.getParent() == null)
      q = new Query(key.getKind());
    else
      q = new Query(key.getKind(), key.getParent());
    q.setKeysOnly();
    q.setFilter(new FilterPredicate(
      Entity.KEY_RESERVED_PROPERTY, FilterOperator.EQUAL, key));
    return 1 == DatastoreServiceFactory.getDatastoreService().prepare(q)
      .countEntities(FetchOptions.Builder.withLimit(1));
}