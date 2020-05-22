public class Test {

  Map<String, Runnable> map = Maps.newHashMap();
  map.put("foo", Test::foo);
  map.put("bar", Test::bar);

  public static void foo() {

  }


  public static void bar() {

  }
}