public class ServerImpl implements ServerInt {

    public static void main(String[] args) {
        ServerImpl server = new ServerImpl();
        server.bind();
    }

    public void bind() {
//        System.setProperty("javax.net.debug", "all");        
        System.setProperty("javax.net.ssl.trustStore", "./resources/server/server_truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");
        System.setProperty("java.rmi.server.hostname", "192.168.0.32");
        System.setProperty("javax.net.ssl.keyStore", "./resources/server/server_keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");


        RMIClientSocketFactory rmiClientSocketFactory = new SslRMIClientSocketFactory();
        RMIServerSocketFactory rmiServerSocketFactory = new SslRMIServerSocketFactory();

        try {


            // Uncomment this line...
            //ServerInt si = (ServerInt) UnicastRemoteObject.exportObject(this, 0);
            // and then comment out this line to turn off SSL (do the same in the ClientImpl.java file)
            ServerInt si = (ServerInt) UnicastRemoteObject.exportObject(this, 0, rmiClientSocketFactory, rmiServerSocketFactory);



            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("server", si);
            System.out.println("Server is bound in registry");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void connect(ClientInt ci) throws RemoteException {
        System.out.println("Client is connected");

        // Generate a really big block of text to send to the client, that way it will be easy to see in a packet
        // capture tool like wireshark and verify that it is in fact encrypted.
        String helloText = "";
        for (int i = 0; i < 10000; i++) {
            helloText += "A";
        }

        ci.sayHelloToClient(helloText);
    }

}