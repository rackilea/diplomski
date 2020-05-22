@Component
public class SavingsAccount implements Account {

  @Autowired
  private Database db;

  @Override
  public void deposit(int money) {
    System.out.println("\n\nSomeModule starts working");
    db.save(money);
  }

}