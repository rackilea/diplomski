public class Main implements OnResponseReceivedListener {

  public static void main(String[] args) {
    Main application = new Main();
    TimeServer ts = application.createTimeServer();
    ts.addOnResponseReceivedListener(application);
    ts.open();
    System.out.println("------------Connected ! ------------");
  }

  @Override
  public void onResponse(String response) {
    doSomethingWith(response);
  }

  private void doSomethingWith(String response) {
    // Your logic for the response here...
  }

  private TimeServer createTimeServer() {
    String host = "192.168.43.178";
    int port = 8080;
    return new TimeServer(host, port);
  }
}