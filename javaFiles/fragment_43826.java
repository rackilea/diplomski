byte[] bytes = new byte[150 * 1024 * 1024];
Arrays.fill(bytes, (byte) '\n');

for (int i = 0; i < 10; i++) {
    long start = System.nanoTime();
    StandardCharsets.UTF_8.decode(ByteBuffer.wrap(bytes));
    long time = System.nanoTime() - start;
    System.out.printf("Time to decode %,d MB was %,d ms%n",
            bytes.length / 1024 / 1024, time / 1000000);
}