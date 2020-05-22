class BImpl implements B, A {

  private A a;

  public BImpl(A a) {
    this.a = a;
  }

  @Override
  public String cellValue() {
    return value() + "MyBCell";
  }

  @Override
  public String value() {
    return a.value();
  }
}