import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

public class StackOverFlow {

    public static void main(String[] args) throws UnknownHostException {
        MongoClient mongo = new MongoClient("localhost:27017");
        DB db = mongo.getDB("db");
        DBCollection collection = db.getCollection("collection");
        BasicDBObject o = new BasicDBObject();
        o.put("key1", "value1");
        o.put("key2", "value2");
        collection.insert(WriteConcern.SAFE, o);

        for (DBObject doc : collection.find()) {
            System.out.println(doc);
        }
    }
}