Database db = client.database("dbTempName", true);

  // Used google.gson.JsonObject instead of org.json.JSONObject. 
  com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
  com.google.gson.JsonObject jsonObject = parser.parse("{\"hello\": \"data\"}").getAsJsonObject();

  db.save(jsonObject);