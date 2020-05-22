public static double sum(double arr[]) {
  double sum = 0.0;
  for (double val : arr) {
    if (!Double.isNaN(val)) {
      sum += val;
    }
  }
  return sum;
}