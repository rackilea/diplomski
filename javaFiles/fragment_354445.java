public int commonDigits(int x, int y) {
  int count = 0;
  int[] digits = new int[10];

  while (x != 0) { 
     digits[x % 10]++;
     x /= 10;
  }
  while (y != 0) {
     if (digits[x % 10] > 0) {
         count++;
         digits[x % 10]--;
     }
     y /= 10;
  }
  return count;
}