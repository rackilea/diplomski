public class SomeOtherClass {
  public static void doSomething(MyClass my) {
    System.out.println(my.getMyField());
  }
  public static void main(String[] args) {
    doSomething(new MyClass(42)); // <-- for example.
  }
}