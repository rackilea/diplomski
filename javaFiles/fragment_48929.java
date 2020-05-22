private void addQueue(ByteBuffer bbuf)
{
    bbuf = ByteBuffer.allocate(bbuf.remaining()).put(bbuf); // copy
    bbuf.flip();
    messageQueue.add(bbuf);
}