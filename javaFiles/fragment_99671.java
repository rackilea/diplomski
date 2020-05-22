public static int ackermann(int m, int n) {
      if(m == 0)  <--nope
         return n + 1;
      if(n == 0) <--nope
         return ackermann(m - 1, 1);
      else
         return ackermann(m - 1, ackermann(m, n - 1)); <-- here we go again
   }