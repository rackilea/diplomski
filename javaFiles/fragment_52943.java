int maximumValue() {
  int maximum = Integer.MIN_VALUE;

  for (int value : arr) {
    if (value > maximum) {
      maximum = value;
    }
  }

  return maximum;
}