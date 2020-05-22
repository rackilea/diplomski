socket.send(request);
socket.setSoTimeout(20000);
try {
    socket.receive(ack);
} catch (SocketTimeoutException e) {
    ...
}