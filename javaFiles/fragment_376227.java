// Assuming you've initialised your SSLContext
  SSLServerSocketFactory sslSf = context.getServerSocketFactory();
  SSLServerSocket server = (SSLServerSocket) sslSf.createServerSocket(port);
  SSLServerSocketFactory ssf = ServerSocketFactory.getDefault();
  server = ssf.createServerSocket(port);      
  SSLSocket socket = (SSLSocket)server.accept();