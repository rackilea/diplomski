class Outer {
  List<Inner> inners = new LinkedList<>();

  public Inner createInnerInstance(int bar) {
    Inner inner = new Inner(bar);
    inners.add( inner );
    return inner;
  }
}