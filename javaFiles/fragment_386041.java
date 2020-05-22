class MyVisitor implements Visitor<Strategy<? extends Base>> {
  @Override
  Strategy<? extends Base> visit(Foo foo) {
    return new FooStrategy();
  }
  @Override
  Strategy<? extends Base> visit(Bar bar) {
    return new BarStrategy();
  }
}