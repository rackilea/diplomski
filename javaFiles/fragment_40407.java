public Random() {
     this(seedUniquifier() ^ System.nanoTime());
 }

 private static long seedUniquifier() {
     // L'Ecuyer, "Tables of Linear Congruential Generators of
     // Different Sizes and Good Lattice Structure", 1999
     for (;;) {
         long current = seedUniquifier.get();
         long next = current * 181783497276652981L;
         if (seedUniquifier.compareAndSet(current, next))
             return next;
     }
 }

 private static final AtomicLong seedUniquifier
     = new AtomicLong(8682522807148012L);