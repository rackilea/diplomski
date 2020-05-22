public class AccountSerializer implements JsonSerializer<Account> {

    @Override
    public JsonElement serialize(Account account, Type type, JsonSerializationContext context) {
        JsonObject root = new JsonObject();
        root.addProperty("id", account.id);
        root.addProperty("email", account.email);
        root.addProperty("encodedPassword", account.getEncodedPassword());

        return root;
    }

}