// Is this block full?
if (one.isLastPacketInBlock()) {
  // wait for the close packet has been acked
  synchronized (dataQueue) {
    while (!shouldStop() && ackQueue.size() != 0) {
      dataQueue.wait(1000);// wait for acks to arrive from datanodes
    }
  }
  if (shouldStop()) {
    continue;
  }

  endBlock();
}