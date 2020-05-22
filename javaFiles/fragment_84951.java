public static BasicDBObject buildOrQuery(List<BasicDBObject> queries) {
    BasicDBList or = new BasicDBList();
    for(BasicDBObject query : queries) {
        or.add(query);
    }
    return new BasicDBObject("$or", or);
}