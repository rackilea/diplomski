System.setProperty("javax.net.ssl.trustStore", "vaserkey");
            System.setProperty("javax.net.ssl.trustStoreSSN", "123456");
        try {
            SSLSocketFactory sslsocketfactory =  (SSLSocketFactory) SSLContext.getDefault().getSocketFactory();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket(args[0], Integer.parseInt(args[1]));
//.....
}