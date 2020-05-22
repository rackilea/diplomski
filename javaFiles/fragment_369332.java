Arrays.fill(isPrime, true);
isPrime[0] = false;
for (int x = 1, x < N; x++) {
   for (int y = x; y < N; y+=x) {
      isPrime[y] = false;
   }
}