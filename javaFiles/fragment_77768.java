public class TestMax {
  public static void main(String[] args) {
    int i = 5;
    int j = 2;
    // The 'natural' ordering means use the compareTo method that is defined on Integer.
    int k = Ordering.<Integer>natural().max(i, j);
    System.out.println("The maximum between is " + k);
  }
}