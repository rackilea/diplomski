public class MongoSandbox {

    public static void main(String[] args) throws UnknownHostException {

        // Connect to local test db
        MongoClientURI uri  = new MongoClientURI("mongodb://localhost:27017/test"); 
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());

        // Get a test collection
        MongoCollection<Document> docs = db.getCollection("docs");

        /* Create a dummy list of events  */
        List<Document> events = new ArrayList<Document>();
        events.add(new Document("random", "data"));
        events.add(new Document("random", "data2"));
        events.add(new Document("random", "data3"));

        // Create your main document
        Document mainDoc = new Document("events", events);
        docs.insert(mainDoc);

        client.close();
    }
}