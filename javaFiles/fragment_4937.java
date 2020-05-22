int findDigit(int num, int n) {

  for (i = 0; i < n-1; i++) {
    num = num / 10;
  }

  return num % 10;
}