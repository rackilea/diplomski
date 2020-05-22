public class User {

    private final long registrationTimeMillis;

    public User(/* various parameters probably would be here */) {
        registrationTimeMillis = System.currentTimeMillis();
    }

    public long getRegistrationTimeMillis() {
        return registrationTimeMillis;
    }
}