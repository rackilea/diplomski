import java.net.*;
import java.io.*;

class GpcSocket {
  private Socket socket;
  // default value
  private int SERVER_PORT = 9999;
  private String SERVER_IP = "192.168.3.100";
  OutputStream out = null;
  InputStream in = null;
  byte[] buffer = new byte[157*10];

  public GpcSocket(String serverIP, int serverPort) {
    this.SERVER_PORT = serverPort;
    this.SERVER_IP = serverIP;
    InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
    socket = new Socket(serverAddr, SERVER_PORT);
  }

  public int send(byte[] str) throws IOException {
    out = socket.getOutputStream();
    out.write(str);
    out.flush();
    // out.close();
    return str.length;
  }

  public byte[] receive() throws IOException {
    in = socket.getInputStream();
    in.read(buffer);
    in.close();
    socket.close()
    return this.buffer;
  }
}