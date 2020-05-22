public static void main(String... args) {
    perfTestIntrinsic();

    perfTestACopy();
}

private static void perfTestIntrinsic() {
    long start = System.nanoTime();
    long countBits = 0;
    for (int i = 0; i < Integer.MAX_VALUE; i++)
        countBits += Integer.bitCount(i);
    long time = System.nanoTime() - start;
    System.out.printf("Intrinsic: Each bit count took %.1f ns, countBits=%d%n", (double) time / Integer.MAX_VALUE, countBits);
}

private static void perfTestACopy() {
    long start2 = System.nanoTime();
    long countBits2 = 0;
    for (int i = 0; i < Integer.MAX_VALUE; i++)
        countBits2 += myBitCount(i);
    long time2 = System.nanoTime() - start2;
    System.out.printf("Copy of same code: Each bit count took %.1f ns, countBits=%d%n", (double) time2 / Integer.MAX_VALUE, countBits2);
}

// Copied from Integer.bitCount()
public static int myBitCount(int i) {
    // HD, Figure 5-2
    i = i - ((i >>> 1) & 0x55555555);
    i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
    i = (i + (i >>> 4)) & 0x0f0f0f0f;
    i = i + (i >>> 8);
    i = i + (i >>> 16);
    return i & 0x3f;
}