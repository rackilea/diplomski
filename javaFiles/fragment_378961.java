import org.json.*;

JSONObject obj = new JSONObject(val); 
JSONArray arr = obj.getJSONArray("column");
for (int i = 0; i < arr.length(); i++)
{
    String post_id = arr.getJSONObject(i).getString("name");
    ......
}