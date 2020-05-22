import javax.net.ssl.SSLSocketFactory;

...

SocketFactory factory = SSLSocketFactory.getDefault();
Socket s = factory.createSocket( host, port );