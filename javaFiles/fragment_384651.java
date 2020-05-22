int snoob1(int x) {
   int smallest, ripple, ones;  // x = xxx0 1111 0000
   smallest = x & -x;           //     0000 0001 0000
   ripple = x + smallest;       //     xxx1 0000 0000
   ones = x ^ ripple;           //     0001 1111 0000
   ones = ones >>> (2 + Integer.numberOfTrailingZeros(x)); //     0000 0000 0111
   return ripple | ones;        //     xxx1 0000 0111
}