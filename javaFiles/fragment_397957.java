double[] generateNRandomDoublesWhichSumToOne(Random random, int n) {
  if (random == null) throw new NullPointerException();
  if (n <= 0) throw new IllegalArgumentException();

  double[] values = new double[n];
  double sum = 0;
  for (int i = 0; i < n; ++i) {
    values[i] = random.nextGaussian();
    sum += values[i];
  }
  for (int i = 0; i < n; ++i) {
    values[i] /= sum;
  }
  return values;
}