final int hash(Object k) {
  int h = hashSeed;
  if (0 != h && k instanceof String) {
     return sun.misc.Hashing.stringHash32((String) k);
  }

  h ^= k.hashCode();
  // This function ensures that hashCodes that differ only by
  // constant multiples at each bit position have a bounded
  // number of collisions (approximately 8 at default load factor).
  h ^= (h >>> 20) ^ (h >>> 12);
  return h ^ (h >>> 7) ^ (h >>> 4);
}