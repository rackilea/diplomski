public class Utilities {

    private static CouchDbClient dbClient;

    public static CouchDbClient dbConnect() {
        if(dbClient == null) {
            dbClient = new CouchDbClient();
        }
        return dbClient;
    }
}