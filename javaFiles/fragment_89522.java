public class User {
    private final int id;
    private final String username;
    private final String pwd;

    public User(int id, String username, String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return id + " " + username + " " + pwd;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

}