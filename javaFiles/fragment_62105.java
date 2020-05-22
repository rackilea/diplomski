import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import java.io.StringReader;
import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class MongoDBTranslator {

    public static JsonObject convertDocumentToJson(org.bson.Document bson) {
        JsonObject obj = null;
        try (StringReader sReader = new StringReader(bson.toJson());
                javax.json.JsonReader reader = Json.createReader(sReader)) {
            obj = reader.readObject();
            reader.close();
        }
        return obj;
    }

    public static DBObject convertJsonToDocument(JsonObject json) {
        StringWriter sw = new StringWriter();
        try (JsonWriter writer = Json.createWriter(sw)) {
            writer.writeObject(json);
            writer.close();
        } catch (Exception ex) {
            //error
            return null;
        }      

        return (DBObject) JSON.parse(sw.toString());
    }

}