@Service
public class MainService {

@Autowired
private SomethingService somethingService;

    @Scheduled(cron = "* * * * * *")
    public void doSomething() {
       somethingService.doSomething();   
    }
}

//Introduce an async component so it does not take 1 second. runs doSomething() in a separate thread

@Component
public class SomethingService {

    @Async
    public void doSomething() {
       //some logic which can takes more than 1 second   
    }
}