interface Foo {
  // Exception might be thrown, but does not have to
  public void bar() throws Exception;
}

class FooImpl implements Foo {
  // FooImpl does not throw exception, so you can omit
  // the throws; it does not hurt if consumer expect an
  // exception that is never thrown
  @Override
  public void bar();
}