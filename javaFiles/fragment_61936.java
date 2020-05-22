class Foo {
  public static void main(String[] args) {
    scala.collection.GenSet<Integer> mySet =
      scala.collection.Set$.MODULE$.<Integer>empty();
    mySet = mySet.$plus(3);
  }
}