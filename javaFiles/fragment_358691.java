public class Cart {
    private final String id;

    @JsonCreator
    public Cart(@JsonProperty("id") String id) { this.id = id;}

    public String getId() { return id; }
}

public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = "{\"id\":\"56c7b5f7-115b-4cb9-9658-acb7b849d5d5\"}";
    Cart cart = mapper.readValue(jsonString, Cart.class);
    System.out.println(mapper.writeValueAsString(cart));
}