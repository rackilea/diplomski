FileChannel fc = new FileInputStream(file).getChannel();
ByteBuffer bb = ByteBuffer.allocateDirect((int) fc.size());
while (bb.remaining() > 0) fc.read(bb);
fc.close();
bb.flip();
// choose the right endianness
ShortBuffer sb = bb.order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();