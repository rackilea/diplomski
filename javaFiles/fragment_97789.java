long startMillis = System.currentTimeMillis();
long endMillis = startMillis + 100;
long currentMillis;
try {
  while ((currentMillis = System.currentTimeMillis()) < endMillis) {
    long soTimeout = endMillis - currentMillis;
    udpSocket.setSoTimeout((int) soTimeout);
    updSocket.receive(udpReceivePacket);
    // ...
  }
} catch (SocketTimeoutException e) {
  // This means that the socket timed out without receiving data in time.
  // You can still read from the socket again (although you probably
  // want to increase the timeout again).
}