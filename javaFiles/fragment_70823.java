public class CustomerDeserializer implements JsonDeserializer<Customer> {

@Override
public Customer deserialize(JsonElement jsonElement, Type typeOf, JsonDeserializationContext context) throws JsonParseException {
    Customer result = null;
    Gson gson = new Gson();

    try {
        // try to deserialize by assuming JSON has a list
        result = gson.fromJson(jsonElement, Customer.class);
    } catch (JsonSyntaxException jse) {
        // error here means JSON has a single string instead of a list

        try {
            // get the single ID
            String custId = jsonElement.getAsJsonObject().get("cust_id").getAsString();

            result = new Customer();
            result.setCustId(Arrays.asList(new String[] {custId}));
        } catch (Exception e) {
            // more error handling here
            e.printStackTrace();
        }
    }

    return result;
}