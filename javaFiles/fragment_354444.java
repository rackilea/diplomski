public int commonDigits(int x, int y) {
  int count = 0;
  BitSet ht = new BitSet();

  while (x != 0) { 
     ht.set(x % 10, true);
     x /= 10;
  }
  while (y != 0) {
     if ((ht.get(y % 10)) {
         count++;
         ht.set(y % 10, false);
     }
     y /= 10;
  }
  return count;
}