ByteBuffer bb = ByteBuffer.allocateDirect(3200).order(ByteOrder.nativeOrder());
for (int i = 0; i < 12; i++) {
    long start = System.nanoTime();
    bb.clear(); // simulate we have 3200 bytes to read.
    int count = 0;
    while (bb.remaining() > 0) {
        float f = bb.getFloat();
        count++;
    }
    long time = System.nanoTime() - start;
    System.out.printf("Took %,d micro-seconds to read %,d float values%n", time / 1000, count);
}