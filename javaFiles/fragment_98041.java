public class App {
  public static void main( String[] args ) throws InterruptedException {
    final int PORT = 8080;
    runInSeparateThread(() -> new Server(PORT));
    runInSeparateThread(() -> new Client(PORT));
  }
  private static void runInSeparateThread(Runnable runnable) {
    new Thread(runnable).start();
  }
}