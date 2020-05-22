import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JsonMergeTest {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        List<Object> myArray = new ArrayList<Object>();
        myArray.add(MyJsonObject.parse("{\"lon\": 0.001, \"lat\": 0.001, \"desc\": \"test\"}"));
        myArray.add(MyJsonObject.parse("{\"lon\": 0.001, \"lat\": 0.001, \"desc\": \"test2\"}"));

        List seenObjects = new ArrayList<Object>();
        for (Object obj : myArray) {
            if (! seenObjects.contains(obj)) {
                seenObjects.add(obj);
            }
            else {
                //merge the 'desc' field in 'obj' with the 'desc' field in the list
                MyJsonObject original = (MyJsonObject)seenObjects.get(seenObjects.indexOf(obj));
                MyJsonObject update = (MyJsonObject)obj;
                original.put("desc", original.get("desc") + ", " + update.get("desc"));
            }
        }

        for (MyJsonObject obj : (List<MyJsonObject>)seenObjects) {
            System.out.println(obj.toJSONString());
        }
    }

    private static class MyJsonObject extends JSONObject  {
        @Override
        public boolean equals(Object obj) {
            if (obj == null || ! (obj instanceof MyJsonObject) || ! this.containsKey("lat") || ! this.containsKey("lon")) {
                return super.equals(obj);
            }
            MyJsonObject jsonObj = (MyJsonObject)obj;
            return this.get("lat").equals(jsonObj.get("lat")) && this.get("lon").equals(jsonObj.get("lon"));
        }

        @Override
        public int hashCode() {
            if (! this.containsKey("lat") || ! this.containsKey("lon")) {
                return super.hashCode();
            }
            return this.get("lat").hashCode() ^ this.get("lon").hashCode();
        }

        @SuppressWarnings("unchecked")
        public static Object parse(String json) {
            Object parsedJson = JSONValue.parse(json);
            if (! (parsedJson instanceof JSONObject)) {
                return parsedJson;
            }

            MyJsonObject result = new MyJsonObject();
            result.putAll((JSONObject)parsedJson);
            return result;
        }
    }
}