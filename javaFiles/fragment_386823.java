import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public static JSONArray jsonResponses = new JSONArray(); 

//inside a method
    strResp = response.body().string();
    try {
        jsonResponses.put(new JSONObject(strResp));
    } catch (JSONException e) {
        e.printStackTrace();
    }