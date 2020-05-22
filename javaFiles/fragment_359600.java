Class SuperClass {
  AbstractClass abstractClass;

  public SuperClass() {
    doStuff();

    abstractClass = new ConcreteClass();
  }
}