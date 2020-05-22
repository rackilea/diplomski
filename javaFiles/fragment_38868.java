public interface Foo {
  @RuntimeType
  Object intercept(@Origin Method m, @AllArguments Object[] a);
}

new ByteBuddy().subclass(Object.class).name("us.levk.guice.vs.Foo")
               .method(any()).intercept(to(new Foo() {
  @RuntimeType
  public Object intercept(@Origin Method m, @AllArguments Object[] a) {
    return null;
  }
}, Foo.class));