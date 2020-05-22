BasicDBObject document = new BasicDBObject();
Pattern regex = Pattern.compile("^((?!Salt).)*$");
QueryBuilder queryBuilder = new QueryBuilder();
queryBuilder.and(
    new QueryBuilder().put("contract").notEquals("none").get(),
    new QueryBuilder().put("contract").notEquals(null).get(),
    new QueryBuilder().put("contract").regex(regex).get()
);
document.putAll(queryBuilder.get());
DBCursor cursor = getDbCollection().find(document);