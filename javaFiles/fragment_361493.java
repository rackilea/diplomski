public class BitSetSieveMain {
    private final BitSet set;
    private final int size;

    public BitSetSieveMain(int x) {
        size = x + 1;
        set = new BitSet(size);
        set.flip(2, size);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            BitSetSieveMain bitSetSieveMain = new BitSetSieveMain(5000);
            bitSetSieveMain.sieve();
            long time = System.nanoTime() - start;
            System.out.println(time / 1000 + " micro-seconds to perform " + bitSetSieveMain);
        }
    }

    public void sieve() {
        int i = 2;
        do {
            for (int j = i*2; j < size; j += i)
                set.clear(j);
            i = set.nextSetBit(i+1);
        } while (i > 0);
    }

    public String toString() {
        return set.toString();
    }
}