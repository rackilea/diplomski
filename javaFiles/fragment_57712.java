String json_string_from_server = "{ 
  "result" : [
    {\"test1\":\"test1_values_baru\", \"test2\":\"test2_values\"}, 
    {\"test1\":\"test‌​1_values\", \"test2\":\"test2_values\"}
  ]
}";

JSONObject jObj = new JSONObject(json_string_from_server);
JSONArray jResultArray = jObj.getJSONArray("result");
for(int i=0; i<jResultArray.length(); i++){
    JSONObject jResultObj = jResultArray.getJSONObject(i);
    String val_Test1 = jResultObj.getString("test1");
    String val_Test2 = jResultObj.getString("test2");
}