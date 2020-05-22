private static final int MAPPING_SIZE = 1 << 30;
...
long size = 8L * width * height;
for (long offset = 0; offset < size; offset += MAPPING_SIZE) {
    long size2 = Math.min(size - offset, MAPPING_SIZE);
    mappings.add(raf.getChannel().map(FileChannel.MapMode.READ_WRITE, offset, size2));
}