abstract class Base {
  final void setFoo(Object param) {  // final, so can't be overridden.
    setFooImpl(param);
    thingThatMustBeCalled();
  }

  protected abstract void setFooImpl(Object param);

  final void thingThatMustBeCalled() { ... }
}

class Derived extends Base {
  @Override protected void setFooImpl(Object param) { ... }
}