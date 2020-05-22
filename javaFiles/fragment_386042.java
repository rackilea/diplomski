class FooStrategy implements Strategy<Base> { void action(Base obj) { ... } }
class BarStrategy implements Strategy<Base> { void action(Base obj) { ... } }

class MyVisitor implements Visitor<Strategy<Base>> {
  @Override
  Strategy<Base> visit(Foo foo) {
    return new FooStrategy();
  }
  @Override
  Strategy<Base> visit(Bar bar) {
    return new BarStrategy();
  }
}

Visitor<Strategy<Base>> visitor = new MyVisitor();
Strategy<Base> strat = drawable.accept(visitor);

Base object;
strat.action(object);