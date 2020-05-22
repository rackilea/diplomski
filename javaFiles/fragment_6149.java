public class TimeServer implements Server {

  public interface OnResponseReceivedListener {
    void onResponse(String response);
  }

  private int port = 2345;
  private String host = "127.0.0.1";
  private ServerSocket server = null;
  private boolean isRunning = true;
  private OnResponseReceivedListener callback;

  public TimeServer() {
    try {
      server = new ServerSocket(port, 100, InetAddress.getByName(host));
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public TimeServer(String pHost, int pPort) {
    host = pHost;
    port = pPort;
    try {
      server = new ServerSocket(port, 100, InetAddress.getByName(host));
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void open() {

    Thread t =
        new Thread(
            new Runnable() {
              public void run() {
                while (isRunning == true) {

                  try {
                    Socket client = server.accept();

                    System.out.println("Connexion cliente reçue.");
                    Thread t = new Thread(new ClientProcessor(client));
                    // Don't forget to define the Server for ClientProcessor
                    t.addServer(TimeServer.this);
                    t.start();

                  } catch (IOException e) {
                    e.printStackTrace();
                  }
                }

                try {
                  server.close();
                } catch (IOException e) {
                  e.printStackTrace();
                  server = null;
                }
              }
            });

    t.start();
  }

  @Override
  public void onResponseReceived(String response) {
    // When the response is received from ClientProcessor
    // this method is called (by ClientProcessor).
    // Your response is the parameter String response.
    callback.onResponse(response);
  }

  public void addOnResponseReceivedListener(OnResponseReceivedListener listener) {
    callback = listener;
  }

  public void removeOnResponseReceivedListener() {
    callback = null;
  }

  public void close() {
    isRunning = false;
  }
}