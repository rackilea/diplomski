public interface PowerfulConnection {
  public void doA();
  public int doB(ParameterForB param);
}

public class ConnectionImpl implements PowerfulConnection {
   // handles the actual connection
}

/**
 * This method is a decorator for PowerfulConnection that synchronizes all method accesses.
 */
public class SynchronizedConnection implements PowerfulConnection {
  private PowerfulConnection target;

  public SynchronizedConnection(PowerfulConnection target) {
    if (target == null) throw new NullPointerException();
    this.target = target;
  }

  public synchronized void doA() {
    target.doA();
  }

  public synchronized int doB(ParameterForB param) {
    return target.doB(param);
  }
}