class MyJsonObjectWrapperDeserializer implements JsonDeserializer<MyJsonObjectWrapper> {
    @Override
    public MyJsonObjectWrapper deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return new MyJsonObjectWrapper(json.getAsJsonObject());
    }
}

class MyJsonObjectWrapper {
    public JsonObject json;

    public MyJsonObjectWrapper(JsonObject json) {
        this.json = json;
    }
}