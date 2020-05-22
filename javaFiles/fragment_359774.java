public class MongoDBManager {
    public MongoClient mongoClient = null;
    String host = "127.0.0.1";
    static MongoDBManager mongo=new MongoDBManager();
    private MongoDBManager() {
        try {
            mongoClient = new MongoClient( host , 27017);
            } catch (UnknownHostException e) {
            System.err.println("Connection errors");
            e.printStackTrace();
        }
    }

    public static MongoDBManager getInstance(){
        return mongo;
    }
}