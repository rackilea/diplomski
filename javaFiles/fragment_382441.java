@Override
public void run() {
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    DataInputStream inFromClient = null;
    DataOutputStream outToClient = null;

    try {
        serverSocket = new ServerSocket(4321);
    } catch (IOException ioe) {
        System.out.println("Could not listen on port 4321. Cause: " + ioe);
        System.exit(-1);
    }

    System.out.println("#Server#listening on port 4321!");

    try {
        clientSocket = serverSocket.accept();
    } catch (IOException ioe) {
        System.out.println("Accept failed on port: 4321. Cause: " + ioe);
        System.exit(-1);
    }

    System.out.println("#Server#accepting connections on port 4321!");

    try {
        inFromClient = new DataInputStream(clientSocket.getInputStream());
        outToClient = new DataOutputStream(clientSocket.getOutputStream());
    } catch (IOException ioe) {
        System.out.println("Input and output streams creation failed. Cause: " + ioe);
        System.exit(-1);
    }

    System.out.println("#Server#created input and output streams!");

    byte[] dataBuffer = new byte[1024];

    try {
        while (true) {
            try {
                int msgLength = 0;

                msgLength = inFromClient.read(dataBuffer);

                String message = new String(dataBuffer);
                System.out.println("Message recieved: " + message);

                outToClient.write(message.getBytes(), 0, msgLength);
                outToClient.flush();
                System.out.println("Echo message sent: " + message);

            } catch (SocketException e) {
                System.out.println("Connection terminated by client.");
                break;
            }
        }

        clientSocket.close();
    } catch (IOException e) {
        System.out.println("Could not listen on port: " + clientSocket.getLocalPort());
        System.out.println("Client thread terminated.");
    } finally {
        try {
            outToClient.close();
            inFromClient.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException ioe) {
            System.out.println("Unable to close streams and sockets. Cause: " + ioe);
            System.exit(-1);
        }
    }
}