@Path("/users")
@Component
class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserAPI userApi;

    UserController(final UserAPI userApi) {
       this.userApi = userApi;
    }

    ...
}