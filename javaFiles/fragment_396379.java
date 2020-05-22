@Service
public class MyRepositoryImpl {

    @Autowired
    private MyMongoRepository myMongoRepository;

    @Autowired
    private MySQLRepository mySQLRepository;

    @PostConstruct
    public void extractUsers(){
        myMongoRepository.findAll().forEach((user) -> System.out.println("user name from mongo is : "+user.getName()));
        mySQLRepository.findAll().forEach((user) -> System.out.println("User name from mysql is : "+user.getName()));
    }

}