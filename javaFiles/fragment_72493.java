public class UserDeserializer implements JsonDeserializer<UserModel> {
    @Override
    public UserModel deserialize(JsonElement jsonElement, Type typeOF,
                                 JsonDeserializationContext context)
            throws JsonParseException {
        String userString = jsonElement.getAsString();
        JsonElement userJson = new JsonParser().parse(userString);

        return new Gson().fromJson(userJson, UserModel.class);
    }
}