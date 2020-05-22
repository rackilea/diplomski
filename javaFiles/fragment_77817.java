static class MyFieldAsValueTypeAdapter<T> implements
        JsonDeserializer<MyField<T>>, JsonSerializer<MyField<T>> {
    private Gson gson = new Gson();
    @Override
    public MyField<T> deserialize(JsonElement json, Type typeOfT,
                                  JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject obj = new JsonObject();
        obj.add("value", json);
        return gson.fromJson(obj, typeOfT);
    }

    @Override
    public JsonElement serialize(MyField<T> src, Type typeOfSrc,
                                 JsonSerializationContext context) {
        return context.serialize(src.getValue());
    }
}

public static void main(String[] args) {
    GsonBuilder b = new GsonBuilder();
    b.registerTypeAdapter(MyField.class , new MyFieldAsValueTypeAdapter());
    Gson gson = b.create();

    String json = "{\"field\":\"value1\"}";
    Test test = gson.fromJson(json, Test.class);
}