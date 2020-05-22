public abstract class MyConst {
  public static final MyConst FOO = new MyConst("foo") {
    public void doSomething() {
      ...
    }
  };

  public static final MyConst BAR = new MyConst("bar") {
    public void doSomething() {
      ...
    }
  };

  protected abstract void doSomething();

  private final String id;

  private MyConst(String id) {
    this.id = id;
  }

  public String toString() {
    return id;
  }
  ...
}