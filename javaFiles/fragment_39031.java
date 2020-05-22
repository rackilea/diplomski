public static void main(String[] args) {
    double upperBound;
    double nd1 = 0.5, nd2;
    double maxGaussian = Double.MIN_VALUE;
    long maxSeed = 0;
    Random rand = new Random();
    long seed;
    int i = 0;
    do {
        nd1 += 0x1.0p-53;
        seed = getSeed(nd1);

        double v1, v2, s;
        v1 = 2 * nd1 - 1;

        if (seed != Long.MAX_VALUE) { // not no seed
            rand.setSeed(seed ^ 0x5deece66dL);
            rand.nextDouble(); // nd1
            nd2 = rand.nextDouble();

            v2 = 2 * nd2 - 1;
            s = v1 * v1 + v2 * v2;
            if (s < 1 && s != 0) { // if not, another seed will catch it
                double gaussian = v1 * StrictMath.sqrt(-2 * StrictMath.log(s) / s);
                if (gaussian > maxGaussian) {
                    maxGaussian = gaussian;
                    maxSeed = seed;
                }
            }
        }

        upperBound = v1 * StrictMath.sqrt(-2 * StrictMath.log(v1 * v1) / (v1 * v1));
        if (i++ % 100000 == 0)
            System.out.println(maxGaussian + " " + upperBound);
    } while (upperBound > maxGaussian);
    System.out.println(maxGaussian + " " + maxSeed);
}