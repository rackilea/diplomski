MongoCollection<Document> collection = mongoClient.getDatabase("stackoverflow").getCollection("dayOfYear");

Document project = new Document("name", 1)
        .append("count", 1)
        .append("dayOfYear", new Document("$dayOfYear", "$TIMESTAMP"));

Document dayOfYearMatch = new Document("dayOfYear", 275);

Document grouping = new Document("_id", "$name").append("total", new Document("$sum", "$count"));

AggregateIterable<Document> documents = collection.aggregate(Arrays.asList(
        new Document("$project", project),
        new Document("$match", dayOfYearMatch),
        new Document("$group", grouping)
));

for (Document document : documents) {
    logger.info("{}", document.toJson());
}