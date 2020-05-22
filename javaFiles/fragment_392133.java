@RequestScoped
public class UserDao {
  private final PersistenceManager pm;

  @Inject
  UserDao(PersistenceManager pm) {
    this.pm = pm;
  }

  public User getUser(parameters) {
    Key key = createKey(parameters);
    User user = pm.getObjectById(User.class, key);
    user.setUserDao(this);
    return user;
  }
}