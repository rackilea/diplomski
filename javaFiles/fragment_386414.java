MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
    MongoDatabase db = mongoClient.getDatabase("testDB");
    AggregateIterable<Document> iterable = db.getCollection("testCollection").aggregate(
            asList(new Document("$unwind", "$data"), new Document("$match", (new Document("_id", new ObjectId(
                    "5636f106b2acf98ecb033b98")).append("data.character", " "))), new Document("$project",
                    new Document("data.color", 1).append("_id", 0))));

    iterable.forEach(new Block<Document>()
    {
        @Override
        public void apply(final Document document)
        {
            System.out.println(document.toJson());
        }
    });