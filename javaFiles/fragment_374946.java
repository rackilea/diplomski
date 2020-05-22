public class Proxy {
public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(1230); // proxy port
    Socket socket = serverSocket.accept();
    Socket relay = new Socket("localhost", 1234); // server address
    new ProxyThread(relay.getInputStream(), socket.getOutputStream()).start();
    new ProxyThread(socket.getInputStream(), relay.getOutputStream()).start();
}
}

class ProxyThread extends Thread {
    private InputStream inputStream;
    private OutputStream outputStream;

ProxyThread(InputStream inputStream, OutputStream outputStream) {
    this.inputStream = inputStream;
    this.outputStream = outputStream;
}

public void run() {
    try {
        int i;
        while ((i = inputStream.read()) != -1){
            outputStream.write(i);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}