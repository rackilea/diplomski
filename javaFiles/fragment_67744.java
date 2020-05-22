public class JsonElementUserDeserializer implements JsonDeserializer<User> {

    @Override
    public User deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
  throws JsonParseException {
      JsonObject userObject = json.getAsJsonObject();

      User user = new User();
      user.getPerson().setName(userObject.get("name").getAsString());
      user.getPerson().setAge(userObject.get("age").getAsInt());
      user.getPersonContacts().setPhone(userObject.get("phone").getAsString());
      user.getPersonContacts().setAge(userObject.get("email").getAsString());
      return user;
   }
}