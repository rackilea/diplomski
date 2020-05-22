// If packet is full, enqueue it for transmission
//
if (currentPacket.getNumChunks() == currentPacket.getMaxChunks() ||
    getStreamer().getBytesCurBlock() == blockSize) {
  enqueueCurrentPacketFull();
}