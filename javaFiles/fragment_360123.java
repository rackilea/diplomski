public class UserDetails {

    private final String name;
    private final String username;
    private final String position;

    public UserDetails(String name, String username, String position) {
        this.name = name;
        this.username = username;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPosition() {
        return position;
    }

}