public static int[] range( int[] a, int low, int high) {
  int result_size=0;
  int i, j;
  // determine result size
  for (i=0; i< a.length;i++) {
    if ((low <= a[i]) && (a[i] <= high)) result_size++;
  }
  // build the result array
  int [] result = new int[result_size];
  j = 0;   // destination
  for (i = 0; i < a.length; i++) {
    if ((low <= a[i]) && (a[i] <= high)) {
      result[j] = a[i];
      j++;
    }
  }
  return result;
}