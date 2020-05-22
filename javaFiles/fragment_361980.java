try (RandomAccessFile out = new RandomAccessFile(file, "rw")) {
    ByteBuffer buffer = ByteBuffer.allocate(totalPkts*4);

    for(int i = 0; i < totalPkts; i++) {
        buffer.putInt(data.get(i));
    }

    buffer.flip();
    byte[] data = new byte[buffer.limit()];
    buffer.get(data);
    out.write(data);
}