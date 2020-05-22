public class Server implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(2323);
            try {
                while (true)
                    processConnection(server.accept());
            } finally {
                server.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processConnection(Socket socket) throws IOException {
        System.out.println("got connection");
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        try {
            while (interpret((Packet) in.readObject()) != 0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    ...
}