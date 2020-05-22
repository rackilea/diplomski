String json = ""; // Your jsonArray
JSONObject result = new JSONObject();
JSONArray arr = new JSONArray(json);
for(int i = 0; i< arr.length() ; i++) {
  JSONObject jsonObj = arr.getJSONObject(i);
  result.put(jsonObj.getString("keyName"), jsonObj.getString("text_EN"));
}
System.out.println(result);