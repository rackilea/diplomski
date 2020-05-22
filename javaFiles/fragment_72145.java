import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest {
    public static void main(String arg[]) throws ParseException {
         JSONObject json = new JSONObject();

         String jsonStrArray = "[{\"a\":\"1\",\"b\":\"2\",\"c\":\"3\"},{\"a\":\"1\",\"b\":\"2\",\"c\":\"3\"},{\"a\":\"1\",\"b\":\"2\",\"c\":\"3\"}]";

         JSONParser parser = new JSONParser();
         JSONArray jo = (JSONArray) parser.parse(jsonStrArray);
         System.out.println(jo);
         json.put("key", jo);
         System.out.println(json);
    }
}