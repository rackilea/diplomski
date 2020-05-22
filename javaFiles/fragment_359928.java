public class ClientImpl implements ClientInt {

    private ServerInt server; 

    public static void main(String[] args) {
        ClientImpl client = new ClientImpl();
        client.bind();
        client.initConnection();
        client.connectToServer();

    }

    public void initConnection() {
        try {
            Registry reg = LocateRegistry.getRegistry("192.168.0.32", 1099);
            server = (ServerInt) reg.lookup("server");

        } catch (RemoteException ex) {
            Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bind() {
//        System.setProperty("javax.net.debug", "all");        
        System.setProperty("javax.net.ssl.trustStore", "./resources/client/client_truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        System.setProperty("java.rmi.server.hostname", "192.168.0.32");
        System.setProperty("javax.net.ssl.keyStore", "./resources/client/client_keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");


        RMIClientSocketFactory rmiClientSocketFactory = new SslRMIClientSocketFactory();
        RMIServerSocketFactory rmiServerSockeyFactory = new SslRMIServerSocketFactory();
        try {

            // Uncomment this line...
            // ClientInt ci = (ClientInt) UnicastRemoteObject.exportObject(this, 0);
            // and comment out this line to turn off SSL (do the same in the ServerImpl.java file)
            ClientInt ci = (ClientInt) UnicastRemoteObject.exportObject(this, 0, rmiClientSocketFactory, rmiServerSockeyFactory);


            Registry reg = LocateRegistry.createRegistry(5001);
            reg.rebind("client", ci);
            System.out.println("Client is bound in registry");
        } catch (RemoteException ex) {
            Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connectToServer() {
        try {
            server.connect(this);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sayHelloToClient(String helloText) throws RemoteException {
        System.out.println(helloText);
    }
}