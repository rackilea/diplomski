// option 1
int value = byteBuffer.getInt(0);

// option 2
buffer.rewind();
int value = byteBuffer.getInt();