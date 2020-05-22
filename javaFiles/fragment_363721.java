JSONArray results = obj.getJsonArray("params");
for (int i = 0, size = results.length(); i < size; i++){
  JSONObject objectInArray = results.getJSONObject(i);
  String[] elementNames = JSONObject.getNames(objectInArray);
  for (String elementName : elementNames) {
    String value = objectInArray.getString(elementName); 
    // in value you have your double
  }
}