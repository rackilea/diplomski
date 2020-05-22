public static ByteBuffer allocateDirect(int capacity) {
    if (capacity < 0) {
        throw new IllegalArgumentException("capacity < 0: " + capacity);
    }
    // Ensure alignment by 8.
    MemoryBlock memoryBlock = MemoryBlock.allocate(capacity + 7);
    long address = memoryBlock.toLong();
    long alignedAddress = (address + 7) & ~(long)7;
    return new DirectByteBuffer(memoryBlock, capacity, (int)(alignedAddress - address), false, null);
}