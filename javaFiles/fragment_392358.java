public static boolean itisSorted(int[] data, int n) {
  // Null or less then 2 elements is sorted.
  if (data == null || n < 2) {
    return true;
  } else if (data[n - 2] > data[n - 1]) {
    // If the element before (n-2) this one (n-1) is greater,
    return false;
  }
  // recurse.
  return itisSorted(data, n - 1);
}

public static void main(String[] args) {
  int [] data = {1,2,3};
  System.out.println(Arrays.toString(data) //
      + (itisSorted(data, data.length) ? " Sorted" : " Unsorted"));
  data = new int[] {3,2,1};
  System.out.println(Arrays.toString(data) //
      + (itisSorted(data, data.length) ? " Sorted" : " Unsorted"));
}