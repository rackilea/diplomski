class ProfileJsonDeserializer implements JsonDeserializer<Profile> {
    @Override
    public Profile deserialize(JsonElement jsonElement, Type type,
            JsonDeserializationContext context) throws JsonParseException {
        if (jsonElement.isJsonPrimitive()) {
            return null;
        }

        return context.deserialize(jsonElement, JsonProfile.class);
    }
}

class JsonProfile extends Profile {

}