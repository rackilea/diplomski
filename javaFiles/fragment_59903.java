public class Foo {
  private static int value; 
  //      ^^^^^^------------ - Here's the problem!

  public Foo(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}