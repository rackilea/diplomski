@Override
public ImagePojo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    Map<String, String> map = new HashMap<>();

    for (Map.Entry<String, JsonElement> element : json.getAsJsonObject().entrySet()) {
        JsonObject jsonObject1 = element.getValue().getAsJsonObject();
        for (Map.Entry<String, JsonElement> jsonElementEntry1 : jsonObject1.entrySet()) {
            String src = jsonElementEntry1.getValue().getAsString();
            map.put(element.getKey(), src);
        }
    }
    return new ImagePojo(map);
}