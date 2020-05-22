@Service
public class MyService {
  @Autowired private TaskExecutor taskExecutor;
  @Autowired private MyRepository myRepository;
  @Autowired private TaskFactory taskFactory;


public void someMethod() {
    MyTask myTask = taskFactory.getTask("myTask")
    taskExecutor.execute(myTask);
}