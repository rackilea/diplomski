import javax.json.*;

public class JsonExample {
    public static void main(String[] args) {
        JsonObject personObject = Json.createObjectBuilder()
                .add("name", Json.createObjectBuilder()
                        .add("given", "John")
                        .add("middle", "Edward")
                        .add("surname", "Doe")
                        .build())
                .add("age", 42)
                .add("isMarried", true)
                .add("address", Json.createObjectBuilder()
                        .add("street", "Main Street")
                        .add("city", "New York")
                        .add("zipCode", "10044")
                        .add("country", "United States")
                        .build())
                .add("phoneNumber", Json.createArrayBuilder()
                        .add("+1 (718) 111-1111")
                        .add("+1 (718) 111-1112")
                        .build())
                .build();

        JsonArray personArray = Json.createArrayBuilder()
                .add(personObject) // Add person to array.
                .build();

        System.out.println(JsonUtil.prettyPrint(personArray));
    }
}