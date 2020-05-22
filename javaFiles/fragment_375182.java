// Note: why on earth is this Serializable? What state are you intending to serialize???
public class Client implements Serializable {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private ObjectOutputStream objectOutputStream;
    private boolean connected = false;
    private static final long serialVersionUID = 0L;


    public void connect(String targetAddress, String username_, int port_) throws IOException {

        clientSocket = new Socket(targetAddress, port_);
        clientSocket.setReuseAddress(true); // Allows same port to be used successively without cool-down
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        objectOutputStream.writeObject(username_);
        connected = true;

    }

    public void disconnect() {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        connected = false;
    }

    public boolean connected() {
        return connected;
    }



    public void sendMessage(String message) {
        out.println(message);
    }
}