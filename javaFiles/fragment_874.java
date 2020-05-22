public abstract class Base {
  public final int doSomething() {
    String tmp = foo();
    int result = bar(tmp);
    return result * result;
  }
  public abstract String foo();
  public abstract int bar(String str);