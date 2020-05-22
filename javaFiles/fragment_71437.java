public class MyStupidException extends Exception {
  public MyStupidException() {
    throw new RuntimeException("whoooo");
  }
}
public static void main(String... args) throws Exception {
  throw new MyStupidException();
}