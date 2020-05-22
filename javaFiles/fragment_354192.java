import org.json.*;

public boolean isValidJSONTest(String yourjsonString) {
    try {
        new JSONObject(yourjsonString);
    } catch (JSONException ex) {

        try {
            new JSONArray(yourjsonString);
        } catch (JSONException ex1) {
            return false;
        }
    }
    return true;
}