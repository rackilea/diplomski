String jsonResponse = restTemplate.getForObject("some_url", String.class);

Type collectionType = new TypeToken<List<JsonResponseTest>>() {}.getType();

JsonObject json = new JsonParser().parse(jsonResponse).getAsJsonObject();
JsonArray jarr = json.getAsJsonObject().getAsJsonArray("files");

List<JsonResponseTest> navigation = gson.fromJson(jarr, collectionType);
System.out.println(navigation);