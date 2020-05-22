public class SSHClientSocketFactory implements RMIClientSocketFactory, Serializable {

public Socket createSocket(String host, int port) throws IOException {
    try {    
    Connection conn = new Connection(hostname, 22);
    conn.connect();
    boolean isAuthenticated = conn.authenticateWithPassword(username, password);
    LocalPortForwarder lpf1 = conn.createLocalPortForwarder(port, serverAddress, port);
        return new Socket(host, port);
    catch (Exception e) {System.out.println("Unable to connect")};
}