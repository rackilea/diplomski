public static double average(List<? extends Number> list) {
  double sum = 0.0;
  for (Number number : list) {
    sum += number.doubleValue();
  }
  return sum / list.size();
}