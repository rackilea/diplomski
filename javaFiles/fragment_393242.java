public class EchoServer {
    private volatile boolean started;
    public void start() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                started = true;

                try {
                    m_ServerSocket = new ServerSocket(12111);
                } catch(IOException ioe) {
                    System.out.println("Could not create server socket at 12111. Quitting.");
                    System.exit(-1);
                }
                System.out.println("Listening for clients on 12111...");

                // Successfully created Server Socket. Now wait for connections.
                int id = 0;

                while (started) {
                    try {

                        Socket clientSocket = m_ServerSocket.accept();
                        ClientServiceThread cliThread = new ClientServiceThread(clientSocket, id++);
                        cliThread.start();    
                    } catch(IOException ioe) {
                        System.out.println("Exception encountered on accept. Ignoring. Stack Trace :");
                        ioe.printStackTrace();
                    }
                }
            }
        }).start();
    }
    public void stop() {
        started = false;
    }
}