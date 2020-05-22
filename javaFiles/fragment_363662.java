public class MyThread implements Runnable {

    private Logger log;
    private ServerSocket socket;
    public MyThread(int port, Logger log) {
        this.log = log;
        log.logToLogger("SocketServer opened on port "+port);
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            log.logToLogger(e.getMessage());
        }
    }

    @Override
    public void run() {
        while(true) {
            Socket server;
            try {
                server = socket.accept();
                log.logToLogger("Connection from"+server.getRemoteSocketAddress()); 
                BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
                log.logToLogger("Received:"+reader.readLine());
                server.close();
            } catch (IOException e) {
                log.logToLogger(e.getMessage());
            }


        }
    }

}

public static void main(String[] args) {
    Integer port = new Integer(args[0]);
    String logTitle = new String(args[1]);
    Logger log = new Logger(logTitle);
    MyThread t = new MyThread(port, log);
    (new Thread(t)).start();
}