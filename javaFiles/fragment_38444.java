import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class GetDataFromJSON {
public static void main(String[] args) {
    String json = "[{\"emp\":{\"age\":34,\"ID\":3423423},\"type\":\"s\"},"
            + "{\"emp\":{\"age\":43,\"ID\":324324235},\"type\":\"s\"},"
            + "{\"emp\":{\"age\":36,\"ID\":324324236},\"type\":\"v\"},"
            + "{\"emp\":{\"age\":46,\"ID\":324324238},\"type\":\"s\"},"
            + "{\"emp\":{\"age\":55,\"ID\":324324243},\"type\":\"s\"},"
            + "{\"emp\":{\"age\":44,\"ID\":324324287},\"type\":\"s\"}]";
    JSONArray jsonArray = getDesiredJSONArray(json);
    System.out.println(jsonArray);
}

public static JSONArray getDesiredJSONArray(String json) {
    JSONArray jsonArray = null;
    JSONArray desiredJsonArray = new JSONArray();
    try {
        jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            // System.out.println(jsonArray.get(i));
            JSONObject object = new JSONObject(jsonArray.get(i).toString());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", object.get("type"));
            object = new JSONObject(object.get("emp").toString());
            jsonObject.put("ID", object.get("ID"));
            jsonObject.put("age", object.get("age"));
            desiredJsonArray.put(jsonObject);
        }
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return desiredJsonArray;
}
}