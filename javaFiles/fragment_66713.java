public class SimpleServer implements Runnable {
    static ServerSocket serverSocket;
    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(8000);
        Thread t = new Thread(new SimpleServer());
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try (Socket socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                //this is too much noise
                //you can directly wrap the result from socket.getInputStream()
                //into the BufferedReader
                BufferedReader br = new BufferedReader( new InputStreamReader(in) )) {

                System.out.println("request from browser client:");
                String line;
                //reads and prints every line from the request
                while ( (line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}