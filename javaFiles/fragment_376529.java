static int countPrime(int k) {
 int count = 2;
 int x = 3;
 int primesFound = 1;
 while (primesFound != k) {
  if (isPrime(x)) {
   count = count * x;
   primesFound++;
  }
  x++;
 }
return count;
}