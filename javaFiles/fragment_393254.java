class Delegator {
  private final ClassA a = new ClassA();
  private final ClassB b = new ClassB();

  public void doWork() {
     a.setup();
     final ResFromA resa = a.getRes();
     b.setup();
     b.consume(resa);
  }

}