System.setProperty("javax.net.ssl.keyStore", "vfserkey");
        System.setProperty("javax.net.ssl.keyStorePassword", "123456");
    try {
        //adding ssl layer to socket connection
        SSLServerSocketFactory sslserversocketfactory =((SSLServerSocketFactory)SSLContext.getDefault().getServerSocketFactory();           SSLServerSocket sslserversocket =(SSLServerSocket) sslserversocketfactory.createServerSocket(Integer.parseInt(args[0]));

      SSLSocket sslsocket = (SSLSocket) sslserversocket.accept();//getting the connection and receiving the data from C}