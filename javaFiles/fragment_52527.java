interface SomeMethods {
  void doSomething();
  void doSomethingElse();
}

class Foo implements SomeMethod {
  public void doSomething() { // implementation }
  public void doSomethingElse() { // implementation }
}

class Bar implements SomeMethod {
   private final Foo foo = new Foo();

   public void doSomething() { foo.doSomething(); }
   public void doSomethingElse() { // do something else! }
}