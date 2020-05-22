JSONObject jsonObject = new JSONObject(jsonAsString);
JSONArray results = jsonObject.getJSONArray("results");
for(int i=0; i<results.length(); i++) {
    JSONObject result = results.getJSONObject(i);
    String username = result.getString("username");
    //...
}