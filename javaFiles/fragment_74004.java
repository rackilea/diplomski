MongoCollection<Document> collection = database.getCollection("myCollection");

AggregateIterable<Document> output = collection.aggregate(Arrays.asList(
        new Document("$unwind", "$views"),
        new Document("$match", new Document("views.isActive", true)),
        new Document("$sort", new Document("views.date", 1)),
        new Document("$limit", 200),
        new Document("$project", new Document("_id", 0)
                    .append("url", "$views.url")
                    .append("date", "$views.date"))
        ));

// Print for demo
for (Document dbObject : output)
{
    System.out.println(dbObject);
}