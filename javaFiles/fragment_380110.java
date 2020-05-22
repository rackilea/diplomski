Gson gson = new Gson();
JsonParser parser = new JsonParser();
String jsonString1 = "{\"id_value\": [{\"id\": \"1.1.1.1\",\"value\": \"v1\"},{\"id\": \"1.1.1.2\",\"value\": \"v2\"}]}";
JsonElement e = parser.parse(jsonString1);
JsonArray idValueArray = e.getAsJsonObject().getAsJsonArray("id_value");
List<IdValue> idValues = gson.fromJson(idValueArray, new TypeToken<List<IdValue>>(){}.getType());