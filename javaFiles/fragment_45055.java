public class BSTVertex extends BinaryVertex<BSTVertex> {
  private static final Random r = new Random();
  public void foo() {
    left = new BSTVertex();
    if(r.nextBoolean()) left.foo();
  }
}