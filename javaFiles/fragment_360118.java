public class ServerSideTCPSocket {

    public void tryCloseSocketConnection(Socket socket) {
        try {
            socket.close();
        }
        catch(java.io.IOException ex) {
        }
    }

    public void processClientConnection (Socket clientConnection) throws java.io.IOException {

        int ch = 0;
        while ((ch = clientConnection.getInputStream().read()) >= 0) {

            System.out.println("Got byte " + ch);
            if (ch == '!') {
                break;
            }
        }
        // Write to output stream

        OutputStream out = clientConnection.getOutputStream();

        String s = "HELLO CLIENT!";
        byte[] bytes = s.getBytes("US-ASCII");

        for (byte b : bytes) {
            System.out.println(b);
            out.write(b);
        }
    }

    public void run() {
        try {
            int serverPort = 4023;
            ServerSocket serverSocket = new ServerSocket(serverPort);
            serverSocket.setSoTimeout(900000);
            while (true) {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

                Socket clientConnection = serverSocket.accept();

                try {
                    System.out.println("Just connected to " + clientConnection.getRemoteSocketAddress());
                    processClientConnection(clientConnection);
                }
                catch (java.io.IOException ex) {
                    System.out.println("Socket connection error - terminating connection");
                }
                finally {
                    tryCloseSocketConnection(clientConnection);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerSideTCPSocket srv = new ServerSideTCPSocket();
        srv.run();
    }
}