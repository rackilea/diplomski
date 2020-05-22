public class GenericGsonTypeAdapter<T> implements JsonSerializer<T>, 
        JsonDeserializer<T> {

    @Override
    public JsonElement serialize(T src, Type typeOfSrc, 
                    JsonSerializationContext context) {
        JsonObject jo = new JsonObject();
        jo.addProperty("className", src.getClass().getName());
        jo.add("jsonData", context.serialize(src));
        return jo;
    }

    @Override
    public T deserialize(JsonElement json, Type typeOfT,
        JsonDeserializationContext context) throws JsonParseException {
        T obj = null;
        if(json instanceof JsonObject) {
            JsonObject jo = (JsonObject) json;
            JsonElement jeJson = jo.get("jsonData");
            if(jeJson != null) {
                JsonElement jeClassName = jo.get("className");
                try {
                    obj = context.deserialize(json,
                                Class.forName(jeClassName.getAsString()));
                } catch (ClassNotFoundException e) {
                    throw new JsonParseException(e);
                }
            }
        }
        return obj;
    }   
}