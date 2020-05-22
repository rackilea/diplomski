import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

.....
String json_data = request.getParameter("json");
JSONArray jsonArray = new JSONArray(json_data);
for(int i=0;i<jsonArray.length();i++) {
                    JSONObject jsonObject=jsonArray.getJSONObject(i);

                    String name=jsonObject.getString("Name");
                    String age=jsonObject.getString("Age");
                }
....