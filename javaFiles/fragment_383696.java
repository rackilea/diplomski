abstract class UnaryFunction<A, B> {
  public abstract B apply(A a);
}

abstract class BinaryFunction<A, B, C> {
  public abstract C apply(A a, B b);
}