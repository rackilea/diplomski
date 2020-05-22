public class Foo<T extends Grok> extends ArrayList<T> {
  private Foo(Class<T> type) {
    String classname = type.getName();
    ...
  }

  public static <T extends Grok> Foo<T> create(Class<T> type) {
    return new Foo<T>(type);
  }

  ...
}