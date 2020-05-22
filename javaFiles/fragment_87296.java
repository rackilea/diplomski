public static void main(String... args) {
    ByteBuffer bb = ByteBuffer.allocateDirect( 1024 * 1024);
    for (int i = 0; i < 5; i++) {
        testEndian(bb.order(ByteOrder.LITTLE_ENDIAN));
        testEndian(bb.order(ByteOrder.BIG_ENDIAN));
    }
}

public static void testEndian(ByteBuffer bb) {
    long start = System.nanoTime();
    int runs = 100;
    for (int i = 0; i < runs; i++) {
        bb.clear();
        int count = 0;
        while (bb.remaining() > 3)
            bb.putInt(count++);
        bb.flip();
        int count2 = 0;
        while (bb.remaining() > 3)
            if (count2++ != bb.getInt())
                throw new AssertionError();
    }
    long time = System.nanoTime() - start;
    System.out.printf(bb.order() + " took %,d μs to write/read %,d ints%n", time / 1000 / runs, bb.capacity() / 4);

}