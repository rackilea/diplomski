Gson gson = new Gson();
JsonParser jsonParser = new JsonParser();
JsonArray jsonArray = jsonParser.parse(json).getAsJsonArray();

for (JsonElement e: jsonArray) {
    JSONClass o = gson.fromJson(e.getAsJsonArray().get(1), JSONClass.class);
}