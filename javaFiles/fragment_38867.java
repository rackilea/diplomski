new ByteBuddy().subclass(Object.class).name("us.levk.guice.vs.Foo")
               .method(any()).intercept(to(new Object() {
  @RuntimeType
  public Object intercept(@Origin Method m, @AllArguments Object[] a) {
    return null;
  }
}));