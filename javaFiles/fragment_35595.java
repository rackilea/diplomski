@Component("myBean")
public class MyBean {

  @Autowired 
  private UserDao userDao;

  @Value("${bean.email}")
  private String myEmailid;
}