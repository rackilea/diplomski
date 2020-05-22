public void findRandomObject() {
    BasicDBObject object = new BasicDBObject("$sample", new BasicDBObject("size", 1));
    AggregationOutput output = getCollection().aggregate(object);

    for (DBObject result : output.results()) {
        LOGGER.info("output >> " + result);
    }
}