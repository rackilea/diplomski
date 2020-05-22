... ...

// initial handshake between peers, don't need Listener:
sslSocket.startHandshake(); // <- this will block the calling thread.
// handshake is completed at this point

... ...