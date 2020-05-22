@Service
public class MyServiceImpl implements MyService {

    @Autowired //constructor-injection
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    private final MyRepository myRepository;

    public void myBusinessLogic() {
        MyPojo pojo = new MyPojo(); //not dependent on Spring
        myRepository.doSomething();
        //place calls to X here as needed
    }
}