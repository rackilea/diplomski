public class Foo {
  public interface Builder extends IBuilder {
    Builder name(String name);
    String name();

    Builder age(int age);
    int age();
    ...
  }

  public static Builder builder() {
    return BuilderFramework.newInstance(Builder.class);
  }

  public Foo(Builder builder) {
    ...
  }
}