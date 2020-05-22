public static void main(String... args) {
    Random r = new Random();
    Iterator<Long> it = randomSequence(r, 10, 32);
    while(it.hasNext()) {
        System.out.println(it.next());
    }
}

/**
 * Random sequence generator.
 *
 * @param r the random generator
 * @param size the number of entries to generate
 * @param shift the number of bits of the result
 * @return the iterator
 */
static Iterator<Long> randomSequence(final Random r, final long size, final int shift) {
    if (size < 5) {
        // small lists are generated using a regular hash set
        TreeSet<Long> set = new TreeSet<Long>();
        while (set.size() < size) {
            set.add(r.nextLong() & ((2L << shift) - 1));
        }
        return set.iterator();
    }
    // large lists are created recursively
    return new Iterator<Long>() {
        long remaining = size, zeros = randomHalf(r, size);
        Iterator<Long> lowBits0 = randomSequence(r, zeros, shift - 1);
        Iterator<Long> lowBits1;
        @Override
        public boolean hasNext() {
            return remaining > 0;
        }
        @Override
        public Long next() {
            remaining--;
            if (lowBits0.hasNext()) {
                return lowBits0.next();
            }
            if (lowBits1 == null) {
                lowBits1 = randomSequence(r, size - zeros, shift - 1);
            }
            return (1L << shift) + lowBits1.next();
        }
    };
}

/**
 * Get the number of entries that are supposed to be below the half,
 * according to the probability theory. For example, for a number of coin
 * flips, how many are heads.
 *
 * @param r the random generator
 * @param samples the total number of entries
 * @return the number of entries that should be used for one half
 */
static long randomHalf(Random r, long samples) {
    long low = 0, high = samples;
    double x = r.nextDouble();
    while (low + 1 < high) {
        long mid = (low + high) / 2;
        double p = probabilityBucketAtMost(samples, mid);
        if (x > p) {
            low = mid;
        } else {
            high = mid;
        }
    }
    return (low + high) / 2;
}

static double probabilityBucketAtMost(long flips, long heads) {
    // https://www.fourmilab.ch/rpkp/experiments/statistics.html
    long x = heads;
    long n = flips;
    double variance = Math.sqrt(n/4);
    // mean
    long mu = n / 2;
    // https://en.wikipedia.org/wiki/Normal_distribution
    // Numerical approximations for the normal CDF
    // the probability that the value of a standard normal random variable X is <= x
    return phi((x - mu) / variance);
}

static double phi(double x) {
    return 0.5 * (1 + Math.signum(x) * Math.sqrt(1 - Math.exp(-2 * x * x / Math.PI)));
}