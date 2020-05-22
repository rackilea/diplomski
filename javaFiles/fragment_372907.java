public class ServerThread implements Runnable {

    private InputStream in;
    private OutputStream out;

    public ServerThread(Socket client) {
        in = client.getInputStream();
        out = client.getOutputStream();
    }

    public void run() {
        // do your socket things 
    }
}