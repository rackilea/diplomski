abstract public class Action<T> implements Runnable {
  private final T param;

  public Action(T param) {
    this.param = param;
  }

  @Override
  public final void run() {
    work(param);
  }

  abstract protected void work(T param);
}