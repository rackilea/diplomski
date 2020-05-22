import javax.json.*;
import java.io.FileReader;
import java.util.List;
import java.util.Set;

public class DataTest {
    public void processJson(String path) {
        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileReader(path));
            JsonObject jsonObj = reader.readObject();
            processJsonObject(jsonObj);
        } catch (Exception ioe) {
            ioe.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private void processJsonObject(JsonObject jsonObj) {
        Set<String> keys = jsonObj.keySet();
        for (String key : keys) {
            JsonValue value = jsonObj.get(key);
            processJsonObject(key, value);
        }
    }

    private void processJsonObject(String key, JsonValue value){
       switch(value.getValueType()){
           case ARRAY:
               processJsonObject(key, (JsonArray)value);
               break;
           default:
               processJsonObject(key, (JsonString)value);
       }
    }

    private void processJsonObject(String key, JsonArray array) {
        System.out.println("Array:  key[" + key + "] = " + "An Array: " + array);
        List<JsonObject> elements = array.getValuesAs(JsonObject.class);
        for(JsonObject element: elements) {
            processJsonObject(element);
        }
    }

    private void processJsonObject(String key, JsonString value) {
        System.out.println("String: key[" + key + "] = " + value);
    }

    public static void main(String[] args) {
        DataTest test = new DataTest();
        test.processJson("/Data/Test/src/main/resources/elements.json");
    }
}