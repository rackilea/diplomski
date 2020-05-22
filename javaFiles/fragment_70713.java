private final LongBuffer keys;
private final IntBuffer values;
private int size;
private int savenum = 0;
private final FileChannel channel1;
private final FileChannel channel2;

public LongIntParallelHashMultimap(int capacity, String st1, String st2) throws IOException {
    boolean newFile = !new File(st1).exists();

    channel1 = new RandomAccessFile(st1, "rw").getChannel();
    MappedByteBuffer mbb1 = channel1.map(FileChannel.MapMode.READ_WRITE, 0, capacity * 8);
    mbb1.order(ByteOrder.nativeOrder());

    keys = mbb1.asLongBuffer();

    channel2 = new RandomAccessFile(st2, "rw").getChannel();
    MappedByteBuffer mbb2 = channel2.map(FileChannel.MapMode.READ_WRITE, 0, capacity * 4);
    mbb2.order(ByteOrder.nativeOrder());

    values = mbb2.asIntBuffer();

    if (newFile)
        for(int i=0;i<capacity;i++)
            keys.put(i, NULL);

    savenum = capacity;
}

public void close() throws IOException {
    channel1.close();
    channel2.close();
}