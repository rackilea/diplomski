import org.springframework.core.task.TaskExecutor;

public class TaskExecutorExample {

  @Autowired  private ADependency aDependency;

  @Autowired
  public TaskExecutorExample(TaskExecutor taskExecutor) {
    this.taskExecutor = taskExecutor;
  }

  public void printMessages() {
    for(int i = 0; i < 25; i++) {
      taskExecutor.execute(new MessagePrinterTask(this.aDependency));
    }
  }
}