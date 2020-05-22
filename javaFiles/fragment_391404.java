public class ThreadHandler{

@Autowired
private TaskFactory taskFactory;


public void someFunction(){
          Runnable task = taskFactory.createTask();
          taskExecutor.execute(task);
      }
}