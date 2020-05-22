public class Server implements Runnable {
    private void acceptConnection() {
            Thread serverThread = new Thread(this);
            serverThread.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(8081);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Got a client !");

                // either open the datainputstream directly
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                // or chain them, but do not open two different streams:
                // DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

                // Your DataStream allows you to read/write objects, use it!
                String data = dis.readUTF();
                System.out.println(data);

                dis.close();
                // in case you have a bufferedInputStream inside of Datainputstream:
                // you do not have to close the bufferedstream
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().acceptConnection();
    }
}