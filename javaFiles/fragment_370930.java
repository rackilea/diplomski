JsonArray jArray = new JsonParser().parse(json1).getAsJsonArray();

for (int j = 0; j < jArray.size(); j++) {
    JsonObject jObject = jArray.get(j).getAsJsonObject();
    String url = jObject.getAsJsonObject("details").get("url").getAsString();
 }