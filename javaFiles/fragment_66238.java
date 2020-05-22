public class Utility{
  private final Foo xx;

  public Utility(Foo xx){
    this.xx = xx;
  }

  public void doWork() {
    // ensures only one thread can be calling action
    synchronized(xx) {
      xx.action();
    }
  }
}