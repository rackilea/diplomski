public class User {

    public String name;
    public String phone;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}