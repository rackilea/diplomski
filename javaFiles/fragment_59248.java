public class ServiceHandler extends Thread {
  private static Object lock = new Object();
  private static ServerLog serverLog = new ServerLog();
  private Socket s;
  private ControllerServer controllerServer;  // Do NOT instantiate it here!

  // Pass your single ControllerServer to the constructor
  public ServiceHandler (Socket socket, ControllerServer controllerServer) {
    this.s = socket;
    this.controllerServer = controllerServer;

    this.start();
  }
}