Record lastRecord = ...;

QueryBuilder queryBuilder = fullTextSession
    .getSearchFactory()
    .buildQueryBuilder()
    .forEntity(Record.class).get();

Query query = queryBuilder.range()
    .onField( "created" )
    .above( lastRecord.getCreated() )
    .createQuery();

FullTextQuery fullTextQuery = fulllTextSession.createFullTextQuery(
    query, Record.class
);