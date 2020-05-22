import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

    public class JsonHelper {
        public static void main() {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Key","value");
            jsonObject.put("Key1","value1");

            JSONArray sensorJsonArray = new JSONArray();
                JSONObject simple = new JSONObject();
                simple.put("JsonArrayKey","JsonArrayValue");
                simple.put("JsonArrayKey1","JsonArrayValue1");
                simple.put("JsonArrayKey2","JsonArrayValue2");
                sensorJsonArray.add(simple);

            try(FileWriter file = new FileWriter("C:\\Users\\Ismr\\work2\\response.json")) {
                jsonObject.put("Array", sensorJsonArray);
                file.write(jsonObject.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }