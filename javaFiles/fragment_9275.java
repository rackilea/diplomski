private void checkDocument(Document doc) {

    MongoClient mongoClient = MongoClients.create("mongodb://localhost/");
    MongoDatabase database = mongoClient.getDatabase("javadb");
    MongoCollection<Document> collection = database.getCollection("users");

    if (collection.find(eq("name", doc.get("name"))).first() == null) {

        System.out.println("### Doc NOT found");
    } 
    else {
        System.out.println("### Doc FOUND");
    }
}