import org.bson.Document;

    import com.mongodb.BasicDBObject;
    import com.mongodb.MongoClient;
    import com.mongodb.ServerAddress;
    import com.mongodb.client.MongoCollection;
    import com.mongodb.client.MongoCursor;
    import com.mongodb.client.MongoDatabase;

    MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));

    MongoDatabase db = mongoClient.getDatabase("local");

    MongoCollection<Document> collection = db.getCollection("sadi");

    BasicDBObject searchQuery = new BasicDBObject();
    searchQuery.put("name","amran");

    MongoCursor<Document> cursor = collection.find(searchQuery).iterator();  
    try {
        while (cursor.hasNext()) {
            System.out.println(cursor.next().toJson());
        }
    } finally {
        cursor.close();
    }