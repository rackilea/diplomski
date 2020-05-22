@Service
public class MyService {
  @Autowired
  private UserDao userDao;

  @Transactional
  public addUser(User user) {
     userDao.insertUser(user);
  }
}