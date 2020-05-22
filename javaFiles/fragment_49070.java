@Component
public class ProfileDemo {

  @Autowired
  private Database db;

  @Autowired
  private Account  account;

  public static void main(String[] args) {
    AnnotationConfigApplicationContext contxt = new AnnotationConfigApplicationContext();
    context.getEnvironment().addActiveProfile("prod");
    context.register(CommonConfiguration.class);
    context.refresh();

    ProfileDemo demo = context.getBean(ProfileDemo.class);

    // Test autowiring of databases based on profile
    demo.db.save(10);
    demo.account.deposit(40);
    context.close();
  }

}