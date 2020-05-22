void enableEncryption(String ssl) throws IOException
{
  Logger.println("Enabling TLS encryption");
  SocketFactory sf = SocketFactories.getSocketFactory(ssl, socket);
  sslSocket = sf.createSocket(getHost(), getPort());
  SSLSocket s = (SSLSocket) sslSocket;
  s.startHandshake();
  setX509Certificates(s.getSession().getPeerCertificateChain());

  setOut(new DataOutputStream(sslSocket.getOutputStream()));
  setIn(new DataInputStream(sslSocket.getInputStream()));
}