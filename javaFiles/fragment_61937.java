class Foo {
  public static void main(String[] args) {
    scala.collection.GenSet<Integer> mySet =
            new scala.collection.immutable.Set.Set1<Integer>(1);
    mySet = mySet.$plus(3);
  }
}