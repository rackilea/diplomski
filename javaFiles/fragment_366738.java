ByteBuffer bb = ByteBuffer.allocateDirect(1024 * 1024);
byte[] bytes = new byte[bb.capacity()];

int runs = 50000;
long start = System.nanoTime();
for (int i = 0; i < runs; i++) {
    bb.clear();
    bb.put(bytes);
}
long time = System.nanoTime() - start;
System.out.printf("Average time to copy 1 MB was %.1f us%n", time / runs / 1e3);