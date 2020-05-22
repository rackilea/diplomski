long tetration(long x, long n) {
   if (n == 0)
     return 1;
   else
     return exp(x, tetration(x, n-1));
}