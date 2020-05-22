public class Server extends Thread {


ExecutorService threadPool = Executors.newCachedThreadPool();

//Private class
class ClientSocket implements Runnable {

    private Socket m_socket;

    ClientSocket(Socket sock) {
        m_socket = sock;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int n = in.readInt();
            long time = n;
            DataOutputStream out = new DataOutputStream(m_socket.getOutputStream());
            out.writeLong(time);
            out.flush();
            System.out.println(time);
            System.out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


@Override
public void run() {
    startServer();
    super.run();
}

private void startServer() {

    try {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("Esperando Conexion");

        do {
            Socket socket = ss.accept();

            threadPool.execute(new ClientSocket(socket));

        } while(true);

    } catch (IOException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}