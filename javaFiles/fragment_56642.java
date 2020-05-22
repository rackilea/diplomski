public List<Team> deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
        throws com.google.gson.JsonParseException {
    if (json.isJsonObject()) {
        return Collections.singleton(context.deserialize(json, Team.class));
    } else {
        return context.deserialize(json, typeOfT);
    }
}