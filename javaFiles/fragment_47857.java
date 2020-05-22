public class run {
  public static void main(String[] argv) {
    ByteArr arr = new ByteArr(4); // Initial size 4
    // You could set some values before passing in if you wanted to.
    test.foo(arr.cast());
    System.out.println(arr.getitem(0) + ", " + arr.getitem(1) + ", " + arr.getitem(2) + ", " + arr.getitem(3));
  }
}