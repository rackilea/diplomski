MulticastSocket socket;
\\initialise socket..
while (running) {
try {
    synchronized (syncRoot) {
    if (sendMessagesQueue.size() > 0) {
        lastOutBoundMessage = sendMessagesQueue.remove();
        byte[] msg = lastOutBoundMessage.toByte();
        DatagramPacket outboundPacket = new DatagramPacket(
            msg, msg.length, group,
            socket.getLocalPort());
        synchronized (syncRoot) {
            socket.send(outboundPacket);
            lastSentMessage = DateTime.now();
        }

        socket.setSoTimeout(WAIT_TIME);
        socket.receive(recv);

        // Compare lastOutBoundMessage  and recv
        // if same set values to null
        // lastSentMessage = null;
        // lastOutBoundMessage = null;
    }
} catch (SocketTimeoutException e) {
    if (lastSentMessage != null && lastSentMessage.plusSeconds(10).isBeforeNow()) {
        running = false;
        // restart thread so connection will start again.
    }
}