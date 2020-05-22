JSONArray carModels = responseBody.getJSONArray("carModels");
for (int i = 0; i < carModels.length(); i++) {
  JSONObject model = carModels.getJSONObject(i);
  JSONArray keys = model.names();
  for (int j = 0; j < keys.length(); j++) {
    Object key = keys.get(j);
    if (model.getJSONObject(key.toString()).get("color").equals("red")) {
      joiner.add(key.toString());
    }
  }
}
System.out.println(joiner);