public class User {

    @JsonProperty("name")
    private String name;

    @JsonProperty("password")
    private String password;

    @NotEmpty(message="other message", groups= {V2Check.class} )
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty(message="asd asd asd", groups= {V1Check.class, V2Check.class } )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public interface V1Check {};
    public interface V2Check {};
}