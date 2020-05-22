public class Client extends Thread {

    private String ip;
    private int port;


    public Client(String serverIP, int serverPort) {
        this.ip = new String(serverIP);
        this.port = serverPort;
    }

    private void startClient() {
        try {
            Socket socket = new Socket(ip, port); 
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Ingrese dato...");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            out.writeInt(n);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            long tiempo = in.readLong();
            System.out.println(tiempo);
            socket.close();
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    @Override
    public void run() {

        startClient();

        super.run();
    }
}