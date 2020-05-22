@Controller
public class CustomerController {
    private static String testId;

    private final CustomerRepository repository;

    private final JpaContext context;

    public CustomerController(CustomerRepository repository, JpaContext context) {
        this.repository = repository;
        this.context = context;
    }

    @PostConstruct
    public void init() {
        Customer customer = new Customer();
        repository.save(customer);
        testId = customer.id;
    }


    @RequestMapping(path = "/test")
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Customer updateScore() {
        Customer customer = repository.findOne(testId);
        System.out.println("start:" + customer.getScore());
        customer.setScore(customer.getScore() - 23);
        saveAndFlush(customer);
        System.out.println("end:" + customer.getScore());
        return customer;
    }

    @Transactional
    public Customer saveAndFlush(Customer customer) {
        return repository.saveAndFlush(customer);
    }
}