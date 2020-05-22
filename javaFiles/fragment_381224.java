public class Test {

  public interface MyInterface { }
  static class AClass implements MyInterface { }

  public static void main(String[] args) {
      MyInterface object = new AClass();
      System.out.println(object.getClass());
  }
}