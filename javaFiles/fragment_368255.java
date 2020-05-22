int sumOfDigits(String str) {
  int sum = 0;
  for (char c : str.toCharArray()) {
    sum += Character.digit(c, 10);
  }
  return sum;
}