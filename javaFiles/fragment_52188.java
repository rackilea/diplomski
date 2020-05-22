public static boolean kindExists (String kind)
{
    Query q = new Query(kind).setKeysOnly();
    PreparedQuery pq = DatastoreServiceFactory.getDatastoreService().prepare(q);
    return (CollectionUtils.isNotEmpty(pq.asList(FetchOptions.Builder.withLimit(1))));
}