static ByteBuffer mapFileSegment(FileChannel fileChannel, long fileSize, long regionOffset, long segmentSize) throws IOException {
    long regionSize = min(segmentSize, fileSize - regionOffset);

    // small last region prevention
    final long remainingSize = fileSize - (regionOffset + regionSize);
    if (remainingSize < segmentSize / 2) {
        regionSize += remainingSize;
    }

    return fileChannel.map(FileChannel.MapMode.READ_ONLY, regionOffset, regionSize);
}

...

final ToIntFunction<ByteBuffer> consumer = ...
try (FileChannel fileChannel = FileChannel.open(Paths.get("/path/to/file", StandardOpenOption.READ)) {
    final long fileSize = fileChannel.size();

    long regionOffset = 0;
    while (regionOffset < fileSize) {
        final ByteBuffer regionBuffer = mapFileSegment(fileChannel, fileSize, regionOffset, segmentSize);
        while (regionBuffer.hasRemaining()) {
            final int usedBytes = consumer.applyAsInt(regionBuffer);
            if (usedBytes == 0)
                break;
        }
        regionOffset += regionBuffer.position();
    }
} catch (IOException ex) {
    throw new UncheckedIOException(ex);
}