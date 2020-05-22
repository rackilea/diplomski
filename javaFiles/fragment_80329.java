@RequestScoped
@Path("/user")
public class UserRest {
  private KwetterApp kwetterApp;
  private UserService userService;

  protected UserRest() {}

  @Inject
  public UserRest(final KwetterApp kwetterApp) {
    this.kwetterApp = kwetterApp;
    this.userService = kwetterApp.getService();
  }

  @GET
  @Produces({"application/json"})
  @Override
  public List<User> get() throws UserException {
    return userService.getAll();
  }
}