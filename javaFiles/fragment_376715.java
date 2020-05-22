import org.apache.zookeeper.Watcher;

public class ZooKeeperConfDTO {
  public String connectString;
  public int sessionTimeout;
  public Watcher watcher;

  public ZooKeeperConfDTO(String connectString, int sessionTimeout, Watcher watcher) {
    this.connectString = connectString;
    this.sessionTimeout = sessionTimeout;
    this.watcher = watcher;
  }
}