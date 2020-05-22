class Client {
    private ClientManager manager;
    private Socket socket;

    private DataOutputStream out;

    public Client(ClientManager manager, Socket socket) {
        this.manager = manager;
        this.socket = socket;
    }

    public void run() {
        try {
            out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            clientManager.sendGlobalMessage("hey!");
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) throws IOException {
        out.writeUTF(message);
    }
}