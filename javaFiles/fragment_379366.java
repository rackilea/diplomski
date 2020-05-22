MongoClient mongoClient = new MongoClient();
MongoDatabase db = mongoClient.getDatabase("db");
MongoCollection<Document> collection = db.getCollection("collection");
Bson aggregates = Aggregates.group("$name",
                Arrays.asList(Accumulators.sum("qualifiedPreviousCount", new Document("$cond", Arrays.<Object>asList(new Document("$and", Arrays.<Object>asList(
                        new Document("$gte", Arrays.<Object>asList("$previousCount", 40)), new Document("$gte", Arrays.<Object>asList("$previousCount", 70))
                )), 1, 0))), Accumulators.sum("qualifiedCurrentCount", new Document("$cond", Arrays.<Object>asList(new Document("$and", Arrays.<Object>asList(
                        new Document("$gte", Arrays.<Object>asList("$currentCount", 10)), new Document("$gte", Arrays.<Object>asList("$currentCount", 50))
                )), 1, 0)))));

List<Document> results = collection.aggregate(Arrays.asList(aggregates)).into(new ArrayList<>());