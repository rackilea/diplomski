public static MongoClient mongoClient;
public static DB db;
public static DBCollection collection;

public static void setupDB() throws UnknownHostException {
    mongoClient = new MongoClient("localhost", port);

    db = mongoClient.getDB("Your Database");

    collection = db.getCollection("Collection Name");

}