AsyncDatastoreService ds = DatastoreServiceFactory.getAsyncDatastoreService();

// create query for your kind
Query query = new Query("Kind");

// we don't need anything else than the key
query.setKeysOnly();

// set the filter for date before now 
query.setFilter(
    new FilterPredicate(
        "date", 
        FilterOperator.LESS_THAN_OR_EQUAL, 
        new Date()));

PreparedQuery pq = ds.prepare(query);

// asIterable is more efficient than asList
for (Entity en : pq.asIterable()) {
    // delete each entity
    ds.delete(en.getKey());
}