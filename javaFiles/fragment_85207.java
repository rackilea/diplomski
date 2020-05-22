public class MyTypeFactory {
  private static MyTypeFactory me;

  @PostConstruct
  public void initialise() {
    if (me == null) {
        me = this;
    }
  }

  public static MyTypeFactory getInstance() {
    return me;
  }

  // The same code as before - getFirst(), getSecond() etc
}