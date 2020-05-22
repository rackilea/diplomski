JSONArray jsonarray = new JSONArray(jsonStr);
for (int i = 0; i < jsonarray.length(); i++) {
    JSONObject jsonobject = jsonarray.getJSONObject(i);
    String name = jsonobject.getString("name");
    String url = jsonobject.getString("url");
}