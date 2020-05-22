System.setProperty("javax.net.ssl.keyStore", "vaserkey");
            System.setProperty("javax.net.ssl.keyStorePassword", "123456");
            //adding ssl layer to socket connection
            SSLServerSocketFactory sslserversocketfactory =SSLServerSocketFactory) SSLContext.getDefault().getServerSocketFactory();                SSLServerSocket sslserversocket =(SSLServerSocket) sslserversocketfactory.createServerSocket(Integer.parseInt(args[0]));
            //taking infinite connection one by one
            while(true){
            //accepting incoming connection
            SSLSocket sslsocket = (SSLSocket) sslserversocket.accept();//....
}catch(Exception e){}
        //after receiving data trying to establish connection with C
            System.setProperty("javax.net.ssl.trustStore", "vfserkey");
            System.setProperty("javax.net.ssl.trustStoreSSN", "123456");
            SSLSocketFactory sslsocketfactory1 = (SSLServerSocketFactory) SSLContext.getDefault().getServerSocketFactory();
            SSLSocket sslsocket1 = (SSLSocket) sslsocketfactory1.createSocket(ip, port);