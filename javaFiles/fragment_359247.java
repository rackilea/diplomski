import java.lang.reflect.*;

class MyObject {
  String x = "hello";
  int y = 42;
  String z = "world";
}

public class Test {
  public static void main(String[] args) throws Exception {
    MyObject obj = new MyObject();
    for (Field f : obj.getClass().getDeclaredFields()) {
      System.out.println(f.getName() + ": " + f.get(obj));
    }
  }
}