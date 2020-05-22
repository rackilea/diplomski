public class TestMax {
  public static void main(String[] args) {
    int i = 5;
    int j = 2;
    Comparator<Integer> compare = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            // Because Integer already implements the method Comparable,
            // This could be changed to "return o1.compareTo(o2);"
            return o1 - o2;
        }
    };
    // Note that this will autobox your ints to Integers.
    int k = compare.compare(i, j) > 0 ? i : j;
    System.out.println("The maximum between is " + k);
  }
}