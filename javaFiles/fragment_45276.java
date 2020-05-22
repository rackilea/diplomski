@Component
public class BankDao {
    public BankDao() {}

    public void createVoid() {
        System.out.println("sth - 1");
    }

    public String createString(){
        return "sth - 2";
    }
}

@Service
public class Account {
    @Autowired
    private final BankDao DAO;

    public Account(BankDao dao) {
        this.DAO = dao;
    }
    public void reserveVoid() {
        System.out.println("before");
        DAO.createVoid();
        System.out.println("after");
    }
    public void reserveString() {
        System.out.println(DAO.createString());
    }
}