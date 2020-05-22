import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray; // Note the import here

public class Test {
    public static void main(String[] args) throws JSONException {
        JSONArray playerIds = new JSONArray();
        playerIds.put("a");
        playerIds.put("b");
        JSONObject notification = new JSONObject();
        notification.put("include_player_ids", playerIds);
        System.out.println(notification);
      }
}