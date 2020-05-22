package clientserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  private static ServerSocket server;
  private static int port = 9876;
  private static Socket p1 = null;
  private static Socket p2 = null;

  static ObjectInputStream ois1, ois2;
  static ObjectOutputStream oos1, oos2;

  public static void main(String args[]) throws Exception {
    System.out.println("server listening on port=" + port);
    server = new ServerSocket(port);

    p1 = server.accept();
    System.out.println("[Server] P1 has connected");
    p2 = server.accept();
    System.out.println("[Server] P2 has connected");

    ois1 = new ObjectInputStream(p1.getInputStream());
    oos1 = new ObjectOutputStream(p1.getOutputStream());
    ois2 = new ObjectInputStream(p2.getInputStream());
    oos2 = new ObjectOutputStream(p2.getOutputStream());

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          while (p1.isConnected()) {
            String message = (String) ois1.readObject();
            System.out.printf("[Server] P1 sent msg=[%s]%n", message);
            if (p2.isConnected()) {
              ObjectOutputStream p2out = oos2;
              p2out.writeObject("[P1] " + message);
            } else {
              oos1.writeObject("[Server] P2 is not connected");
            }
          }
          System.out.println("[Server] P1 has disconnected");
        } catch (Exception e) {
          e.printStackTrace(System.out);
        }
      }
    }).start();
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          while (p2.isConnected()) {
            String message = (String) ois2.readObject();
            System.out.printf("[Server] P2 sent msg=[%s]%n", message);
            if (p1.isConnected()) {
              ObjectOutputStream p1out = oos1;
              p1out.writeObject("[P2] " + message);
            } else {
              oos2.writeObject("[Server] P1 is not connected");
            }
          }
          System.out.println("[Server] P2 has disconnected");
        } catch (Exception e) {
          e.printStackTrace(System.out);
        }
      }
    }).start();
  }
}