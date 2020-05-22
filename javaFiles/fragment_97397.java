// Test.java
public abstract class Test<T> {
  public T get(int i) {
    return null;
  }
  public static void main(String[] args) {
    StringTest st = new StringTest();
    String s = st.get(0);
    System.out.println(s); // prints: null
  }
}
class StringTest extends Test<String> {
    public StringTest() { }
}