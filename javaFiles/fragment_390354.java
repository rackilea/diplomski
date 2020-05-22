JsonObject root = new JsonObject();
root.addProperty("first_name", "prod");

JsonElement element = new JsonParser().parse(complexJsonString);
root.addProperty("data", element);

String json = new Gson().toJson(root);