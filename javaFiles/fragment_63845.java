public class UnsafeBooleanPair {
    private static final Unsafe UNSAFE;

    private static final long[] OFFS = new long[2];
    private static final long[] MASKS = new long[] {
        -1L >>> 32L, -1L << 32L
    };

    static {
        try {
            UNSAFE = getTheUnsafe();

            Field pair = UnsafeBooleanPair.class.getDeclaredField("pair");
            OFFS[0] = UNSAFE.objectFieldOffset(pair);
            OFFS[1] = OFFS[0] + 4L;

        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private volatile long pair;

    public void set(int ind, boolean val) {
        UNSAFE.putIntVolatile(this, OFFS[ind], val ? 1 : 0);
    }

    public boolean get(int ind) {
        return (pair & MASKS[ind]) != 0L;
    }

    public boolean[] get(boolean[] vals) {
        long p = pair;
        vals[0] = (p & MASKS[0]) != 0L;
        vals[1] = (p & MASKS[1]) != 0L;
        return vals;
    }

    private static Unsafe getTheUnsafe()
    throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe)theUnsafe.get(null);
    }
}