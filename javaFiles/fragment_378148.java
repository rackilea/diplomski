public class Main {
  void method(Object o) {
    System.out.println(this.getClass() == o.getClass());
  }

  public static void main(String[] args) {
    new Main().method(new Object());  // false
    new Main().method(new Main());    // true
    new Main().method(new String());  // false
    new Main().method(new MainOne()); // false
  }
}

class MainOne extends Main
{
}