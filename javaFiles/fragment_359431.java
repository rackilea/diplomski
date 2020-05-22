public class InvRand {
    private static final long addend = 0xBL;
    private static final long multiplier = 0x5DEECE66DL;
    private static final long invMultiplier = 0xDFE05BCB1365L;
    private static final long mask = 0xFFFFFFFFFFFFL;

    private long seed;

    public InvRand(Random r) {
        seed = prevSeed(replicateSeed(r.nextLong()));
    }

    public long prevLong() {
        seed = prevSeed(seed);
        long b1 = seed >>> 16;
        seed = prevSeed(seed);
        long b2 = seed >>> 16;
        return (b2 << 32) + b1;
    }

    static long replicateSeed(long nextLong) {
        int nextM = (int)(nextLong & 0xFFFFFFFF);
        int nextN = (int)((nextLong - nextM) >> 32);

        long upperMOf48Mask = 0xFFFFFFFF0000L;

        long oldSeedUpperN = ((long)nextN << 16) & mask;
        long newSeedUpperM = ((long)nextM << 16) & mask;

        for (long oldSeed = oldSeedUpperN; oldSeed <= (oldSeedUpperN | 0xFFFF); 
                  oldSeed++) {
            long newSeed = (oldSeed * multiplier + addend) & mask;
            if ((newSeed & upperMOf48Mask) == newSeedUpperM) {
                return newSeed;
            }
        }
        throw new InternalError();
    }

    static long prevSeed(long seed) {
        return ((seed - addend) * invMultiplier) & mask;
    }
}