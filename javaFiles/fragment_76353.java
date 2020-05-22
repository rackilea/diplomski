public interface Updatable {
  void updated();
}

public interface Loadable {
  void load();
}

public class DefaultUpdatable implements Updatable {
 ...
}

public class DefaultLoadable implements Loadable {
 ...
}

public class SomeObject implements Updatable, Loadable {
  private final Updatable updatable = new DefaultUpdatable();
  private final Loadable loadable = new DefaultLoadable();

  public void load() {
    this.loadable.load();
  }

  public void updated() {
    this.updatable.updated();
  }
}