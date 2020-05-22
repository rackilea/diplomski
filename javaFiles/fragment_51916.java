@Component
public class AuthenticationFailureListener
    implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

  @Autowired
  private UserDao userDao;

  public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent ev) {

    String username = ev.getAuthentication().getName();

    User user = userDao.find("name", username);
    if (user != null) { // only for existing users
            user.reportLoginFailure();
            userDao.commit();
    }
  }
}