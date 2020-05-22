public class Static {

  private final static Static INSTANCE = new Static();

  public static Static doStuff(...) {
     ...;
     return INSTANCE;
  }

  public static Static doOtherStuff() {
    ....
    return INSTANCE;
  }
}