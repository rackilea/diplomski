class Bar implements Operable<Foo> {
  @Override
  public Foo prepare() {
    System.out.println("Preparing...");
    // Why is this needed, you ask? Because you are now expressing this:
    return (Foo) this; // this is of type Bar, not Foo
  }
  ...
}