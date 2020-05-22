@JsonPOJOBuilder(withPrefix = "")
public static class UserBuilder {

    @JsonProperty("user_name")
    @NonNull
    private String userName;
}