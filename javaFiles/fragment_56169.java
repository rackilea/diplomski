int seed = (int) System.nanoTime();
final int origSeed = seed;

public int nextUniqueNegativeNumber() {
  int n = seed;
  do {
    n ^= (n << 13);
    n ^= (n >>> 17);
    n ^= (n << 5);
    seed = n;
    if (n == origSeed) {
      throw new InternalError("Run out of numbers!");
    }
  } while (n > 0);
  return n;
}