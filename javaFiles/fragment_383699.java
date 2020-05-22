abstract class BinaryOperation {
  public abstract int apply(int a, int b);

  public UnaryOperation partial(final int a) {
    return new UnaryOperation() {
      public int apply(int b) {
        return BinaryOperation.this.apply(a, b);
      }
    };
  }
}