static void countPrime(int k) {
 int x = 2;
 int primesFound = 0;
 while (primesFound != k) {
  if (isPrime(x)) {
   System.out.print(x);
   primesFound++;
  }
  x++;
 }
}