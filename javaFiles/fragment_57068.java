class Junction<E extends A & B> {
  private final E value;
  public Junction(E value) {
    this.value = value;
  }
  public E getValue() {
    return value;
  }
}

class Foo {
  private Junction<?> junction;
  public <E extends A & B> void setValue(E value) {
    junction = new Junction<E>(value);
  }
}