static final long a = Long.parseUnsignedLong("2862933555777941757"); // values taken from https://nuclear.llnl.gov/CNP/rng/rngman/node4.html
static final long c = Long.parseUnsignedLong("3037000493");

double mapToDouble(final int i) {
    long seed = (long)i;
    long mapl = a * seed + c; // should do wraparound automatically, or use Long.remainderUnsigned
    double x  = (x >>> 11) * 0x1.0p-53; // see http://xoshiro.di.unimi.it/
    return x;
}