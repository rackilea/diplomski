@Configurable
public class MyTask implements Runnable { ... }

@Service
public class MyService {
   @Autowired private TaskExecutor taskExecutor;

   public void someMethod() {

     // AspectJ would jump in here and inject MyTask transparently
     MyTask myTask = new MyTask();
     taskExecutor.execute(myTask);

}