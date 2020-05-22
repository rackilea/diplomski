MongoCollection<Document> collection = mongoClient.getDatabase("stackoverflow").getCollection("dayOfYear");

Document redact = new Document("$cond", new Document("if", new Document("$eq", Arrays.asList(new Document("$dayOfYear", "$TIMESTAMP"), 275)))
        .append("then", "$$KEEP")
        .append("else", "$$PRUNE"));

Document grouping = new Document("_id", "$name").append("total", new Document("$sum", "$count"));

AggregateIterable<Document> documents = collection.aggregate(Arrays.asList(
        new Document("$redact", redact),
        new Document("$group", grouping)
));

for (Document document : documents) {
    logger.info("{}", document.toJson());
}