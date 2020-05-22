public class SingleThreadExecutor implements Executor {
  @Override
  public void execute(Runnable command) {
    command.run();
  }
}