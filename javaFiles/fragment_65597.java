@Builder
public class User {
    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    private String username;

    private String password;

    public static class UserBuilder {
        public UserBuilder password(String password) {
            this.password = ENCODER.encode(password);
            return this;
        }
    }
}