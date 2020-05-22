public class Test {

    public static void main(String[] args) {
        Server server = new Server();
        server.start(100);  // server port no 100
    }

}

class Server {

    /**
     * Thread that continuously reads data from socket.
     */
    private Thread reader;

    /**
     * Thread that continuously writes data to socket.
     */
    private Thread writer;

    /**
     * Start server
     * @param port
     * @throws IOException
     */
    void start(int port) throws IOException {
        ServerSocket srv = new ServerSocket(port);

        // Wait for client connection
        Socket clientSocket = srv.accept();

        // Client connected
        startReadingAndWritingData(clientSocket);
    }

    /**
     * Starts reader and writer threads.
     * 
     * @param socket
     *            client socket
     * @throws IOException
     */
    private void startReadingAndWritingData(Socket socket) throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
                socket.getInputStream()));

        ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(socket.getOutputStream()));

        ReaderThread reader = new ReaderThread(ois);
        WriterThread writer = new WriterThread(oos);
            reader.start();
            writer.start();

    }
}

class WriterThread extends Thread {

    private ObjectOutputStream oos;

    /**
     * Constructor.
     * 
     * @param oos
     */
    WriterThread(ObjectOutputStream oos) {
        super();
        this.oos = oos;
    }

    public void run() {
        while (true) {
            try {
                String output = getNextOutput();
                oos.writeObject(output);

                Thread.sleep(1000); // Wait before sending next String
            } catch (Exception e) {
                /*
                 * Socket IO or serialization error
                 */
                e.printStackTrace();
                break;
            }
        }
    }

    /**
     * Get output String from somewhere eg. file.
     * 
     * @return output
     */
    private String getNextOutput() {
        // TODO get output String from somewhere
    }

}

/**
 * Reader thread.
 * 
 */
class ReaderThread extends Thread {

    private ObjectInputStream ois;

    /**
     * Constructor.
     * 
     * @param ois
     */
    ReaderThread(ObjectInputStream ois) {
        super();
        this.ois = ois;
    }

    public void run() {
        while (true) {
            try {
                String input = (String) ois.readObject();
                handleInput(input);
            } catch (Exception e) {
                /*
                 * Socket IO or deserialization error
                 */
                e.printStackTrace();
                break;
            }
        }
    }

    /**
     * Handle received input String.
     * 
     * @param input
     */
    private void handleInput(String input) {
        // TODO handle input

    }

}