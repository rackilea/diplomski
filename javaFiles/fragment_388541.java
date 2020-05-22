public class UserForm {

    private MultipartFile avatar; 

    @NotEmpty
    private String username;

    @Size(min = 6)
    @NotEmpty
    private String password;

    public UserForm() {}

    public UserForm(String username) {
         this.username = username;
    }

    static UserForm of(User user) {
        return new UserForm(user.getUsername());
    }

    // getters/setters omitted for brevity
}