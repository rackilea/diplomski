public class MyTypeAdapter implements JsonSerializer<MapWrapper>, JsonDeserializer<MapWrapper> {
    @Override
    public JsonElement serialize(MapWrapper src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject obj = new JsonObject();
        src.wrapped.entrySet().forEach(e -> obj.add(e.getKey(), new JsonPrimitive(e.getValue())));
        return obj;
    }

    @Override
    public MapWrapper deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        MapWrapper wrapper = new MapWrapper();
        json.getAsJsonObject().entrySet().forEach(e -> wrapper.wrapped.put(e.getKey(), e.getValue().getAsInt()));
        return wrapper;
    }
}