@Component
public class AuthenticationSuccessEventListener
    implements ApplicationListener<AuthenticationSuccessEvent>{

  @Autowired
  private UserDao userDao;

  public void onApplicationEvent(AuthenticationSuccessEvent event) {

    String username = event.getAuthentication().getName();

    User user = userDao.find("name", username);
    user.reportLoginOK();
    userDao.commit();
  }
}