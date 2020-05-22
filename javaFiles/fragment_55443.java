public static void main(String[] args) {
    try (MongoClient client = new MongoClient("127.0.0.1")) {
        MongoCollection<Document> col = client.getDatabase("test").getCollection("test");

        Document groupFields = new Document("_id", "$page");
        groupFields.put("count", new Document("$sum", 1));
        groupFields.put("impressions", new Document("$first", "$impressions"));
        groupFields.put("position", new Document("$first", "$position"));

        Document matchFields = new Document("count", 1);

        Document projectFields = new Document("_id", 0);
        projectFields.put("page", "$_id");
        projectFields.put("impressions", 1);
        projectFields.put("position", 1);

        AggregateIterable<Document> output = col.aggregate(Arrays.asList(
                new Document("$group", groupFields),
                new Document("$match", matchFields),
                new Document("$project", projectFields)
        ));

        for (Document doc : output) {
            System.out.println(doc);
        }
    }
}