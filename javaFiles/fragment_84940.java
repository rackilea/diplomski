private static final double MIXDOWN_VOLUME = 1.0 / NUM_PRODUCERS;

    private final List<QueuedBlock> finished = new ArrayList<>();
    private final short[] mixBuffer = new short[BUFFER_SIZE_FRAMES * CHANNELS];
    private final byte[] audioBuffer = new byte[BUFFER_SIZE_FRAMES * CHANNELS * 2];
    private final AtomicLong position = new AtomicLong();

    Arrays.fill(mixBuffer, (short) 0);
    long bufferStartAt = position.get();
    for (QueuedBlock block : scheduledBlocks) {
        int blockFrames = block.data.length / CHANNELS;

        // block fully played - mark for deletion
        if (block.when + blockFrames <= bufferStartAt) {
            finished.add(block);
            continue;
        }

        // block starts after end of current buffer
        if (bufferStartAt + BUFFER_SIZE_FRAMES <= block.when)
            continue;

        // mix in part of the block which overlaps current buffer
        int blockOffset = Math.max(0, (int) (bufferStartAt - block.when));
        int blockMaxFrames = blockFrames - blockOffset;
        int bufferOffset = Math.max(0, (int) (block.when - bufferStartAt));
        int bufferMaxFrames = BUFFER_SIZE_FRAMES - bufferOffset;
        for (int f = 0; f < blockMaxFrames && f < bufferMaxFrames; f++)
            for (int c = 0; c < CHANNELS; c++) {
                int bufferIndex = (bufferOffset + f) * CHANNELS + c;
                int blockIndex = (blockOffset + f) * CHANNELS + c;
                mixBuffer[bufferIndex] += (short)
                    (block.data[blockIndex]*MIXDOWN_VOLUME);
            }
    }

    scheduledBlocks.removeAll(finished);
    finished.clear();
    ByteBuffer
        .wrap(audioBuffer)
        .order(ByteOrder.LITTLE_ENDIAN)
        .asShortBuffer()
        .put(mixBuffer);
    line.write(audioBuffer, 0, audioBuffer.length);
    position.addAndGet(BUFFER_SIZE_FRAMES);