public static int[][] obstacle = { { 1, 3 }, { 2, 2 } };

public static boolean testerFunction(int j, int k) {
  int[] check = { j, k };
  for (int[] a : obstacle) {
    if (Arrays.equals(a, check)) {
      return true;
    }
  }
  return false;
}

public static void main(String[] args) {
  System.out.println(testerFunction(1, 3)); // true
  System.out.println(testerFunction(2, 2)); // true
  System.out.println(testerFunction(0, 0)); // false
}