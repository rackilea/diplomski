public class MyClass {

  private MyClass() {}

  public static MyClass create() {
      return new MyOtherClass();
  }

  private static class MyOtherClass extends MyClass {
    ...
  }
}