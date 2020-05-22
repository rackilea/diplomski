/**
 * if encountering a block boundary, send an empty packet to
 * indicate the end of block and reset bytesCurBlock.
 *
 * @throws IOException
 */
protected void endBlock() throws IOException {
    if (getStreamer().getBytesCurBlock() == blockSize) {
      setCurrentPacketToEmpty();
      enqueueCurrentPacket();
      getStreamer().setBytesCurBlock(0);
      lastFlushOffset = 0;
    }
}