Random random = new Random(0);
mdn = new String[4][1<<16];
for (int i=0; i<mdn.length; ++i) {
    mdn[0][i] = String.format("%03ddsfasdf00000", random.nextInt(1000));
    mdn[1][i] = String.format("%04d", random.nextInt(10000));
    mdn[2][i] = String.format("%10d", random.nextInt((int) 1e10));
    mdn[3][i] = String.format("%03d-%03d-%03d", random.nextInt(1000), random.nextInt(1000), random.nextInt(1000));
}