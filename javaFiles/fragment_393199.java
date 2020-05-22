@ApplicationScoped
public class GetUser {

    @Inject
    private UserService userService;

    public ApplicationUser getUser(String userId) {
        // ...
    }
}