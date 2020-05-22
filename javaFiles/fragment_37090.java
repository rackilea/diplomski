public class UserDTO implements Serializable {
    @JsonProperty("username")
    private String username;

    public void setUsername(String username) {
        this.username = username.replace("A", "B");
    }

    public String getUsername() {
        return this.username;
    }
}