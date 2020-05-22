public class BinaryVertex<T extends BinaryVertex<T>> {
    public T parent, left, right;
}

public class BSTVertex extends BinaryVertex<BSTVertex> {
  public void foo() {
    left = new BSTVertex();
    if(Math.floor(Math.random()*2) == 0) left.foo();
  }
}