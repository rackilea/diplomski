class MyDeserializer implements JsonDeserializer<Dummy>
{
    @Override
    public Dummy deserialize(JsonElement json, Type typeOfT, 
                              JsonDeserializationContext context)
                    throws JsonParseException
    {
        JsonObject jsonObject = (JsonObject) json;

        if (jsonObject.get("error") != null)
        {
            throw new JsonParseException("Error!");
        }

        return new Gson().fromJson(json, Dummy.class);
    }
}