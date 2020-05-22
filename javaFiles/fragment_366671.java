JSONObject json = new JSONObject();
json.put("list", new JSONArray());
...

while (oResultSet.next()) {
    JSONObject obj = new JSONObject();
    obj.accumulate("nombre", oResultSet.getString("nombre"));
    obj.accumulate("goles", oResultSet.getInt("goles"));
    json.getJSONArray("list").add(obj);
}