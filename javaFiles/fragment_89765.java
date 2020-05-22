public double Sum(int first) {
  if (first <= 1) {
    return 1;
  } else {
    return first / (2.0 * first - 1) + Sum(first - 1);
  }
}