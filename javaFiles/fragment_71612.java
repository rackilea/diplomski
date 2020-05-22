//result is your json data in the form of string..convert json data to string.
JSONObject returnValue = new JSONObject(result);

//getting array from json
JSONArray results= returnValue.getJSONArray("results");

for (int i = 0; i < results.length(); i++) {
  JSONObject ParentObject = results.getJSONObject(i);

  //getting particular_key...
  String format_addrs=ParentObject.getString("formatted_address");     
}