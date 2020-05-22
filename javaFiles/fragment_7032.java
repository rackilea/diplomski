public class Main {
    private static class LongBitSet {
        // max value stored in single BitSet
        private static final int BITSET_SIZE = 1 << 30;

        BitSet[] bitsets;

        public LongBitSet(long limit) {
            bitsets = new BitSet[(int) (limit/BITSET_SIZE+1)];
            // set all bits by default
            for(int i=0; i<bitsets.length; i++) {
                bitsets[i] = new BitSet();
                int max = (int) (i == bitsets.length-1 ?
                          limit % BITSET_SIZE : BITSET_SIZE);
                bitsets[i].set(0, max);
            }
        }

        // clear specified bit
        public void clear(long pos) {
            bitsets[(int) (pos / BITSET_SIZE)].clear((int) (pos % BITSET_SIZE));
        }

        // get the value of the specified bit
        public boolean get(long pos) {
            return bitsets[(int) (pos / BITSET_SIZE)].get((int) (pos % BITSET_SIZE));
        }

        // get the number of set bits
        public long cardinality() {
            long cardinality = 0;
            for(BitSet bs : bitsets) {
                cardinality += bs.cardinality();
            }
            return cardinality;
        }
    }

    public static void main(String args[]) {
        long N = 4000000000L;

        // initially assume all integers are prime

        LongBitSet bs = new LongBitSet(N+1);
        // clear 0 and 1: non-primes
        bs.clear(0);
        bs.clear(1);

        // mark non-primes <= N using Sieve of Eratosthenes
        for (long i = 2; i * i <= N; i++) {
            if (bs.get(i)) {
                for (long j = i; i * j <= N; j++) {
                    bs.clear(i * j);
                }
            }
        }
        System.out.println(bs.cardinality());
    }
}