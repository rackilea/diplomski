public class Customer {
    @JsonProperty("customer_id")
    private long customerId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("town")
    private String town;
}