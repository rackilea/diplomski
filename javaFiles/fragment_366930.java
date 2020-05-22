import java.io.*;
import java.net.*;

public class SelectTest {
  public static void main(String[] args) throws Exception {
    // Use 1024 file descriptors. There'll already be some in use, obviously, but this guarantees the problem will occur
    for(int i = 0; i < 1024; i++) {
      new FileInputStream("/dev/null");
    }
    ServerSocket socket = new ServerSocket(8080);
    socket.accept();
  }
}