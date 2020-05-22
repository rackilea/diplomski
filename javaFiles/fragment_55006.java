public class Account {

    @Id
    @NotNull
    private String id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String role;
}