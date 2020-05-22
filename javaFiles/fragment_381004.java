public class UserRequest {

    // --> NOTICE THE ANNOTATION HERE <--
    @UniqueEmail(message = "email already registered")
    private final String email;

    public UserRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}