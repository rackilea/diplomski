MongoClient mongoClient = new MongoClient();
    MongoDatabase db = mongoClient.getDatabase("test");
    MongoCollection collection = db.getCollection("test");

    Iterable<Document> output = collection.aggregate(asList(
             new BasicDBObject("$unwind", "$journals"),
             new BasicDBObject("$match", new BasicDBObject("journals.deleteFl", false))
    ));

    for (Document dbObject : output)
    {
        System.out.println(dbObject);
    }