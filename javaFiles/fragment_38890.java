public class PlayerConnection implements Runnable {

    private Server parent;

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    protected PlayerConnection(Server parent, Socket socket) throws IOException {
        try {
            socket.setSoTimeout(0);
            socket.setKeepAlive(true);
        } catch (SocketException e) {}

        this.parent = parent;
        this.socket = socket;

        this.out    = new DataOutputStream(socket.getOutputStream());;
        this.in     = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {                 
        while(!this.socket.isClosed()) {                        
            try {
                int nextEvent = this.in.readInt();

                switch (nextEvent) {
                    // handle event and inform Server
                }
            } catch (IOException e) {}
        }

        try {
            this.closeConnection();
        } catch (IOException e) {}
    }
}