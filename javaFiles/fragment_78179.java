JsonElement root = new JsonParser()
    .parse(new FileReader("data.json"));

JsonArray data = root.getAsJsonObject()
    .getAsJsonObject("dataset_data")
    .getAsJsonArray("data");

System.out.println(data.size());