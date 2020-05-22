public class UserDTO implements Serializable {
    private String username;

    @JsonCreator
    public UserDTO(@JsonProperty("username") String username) {
        this.username = username.replace("A", "B");
    }

    public String getUsername() {
        return this.username;
    }
}