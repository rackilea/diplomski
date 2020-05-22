public class Printer implements Runnable {

  public volatile boolean keepPrinting;

  public static void main(String... args) {
    Printer printer = new Printer();
    Gui gui = new Gui(printer);
    Thread t = new Thread(printer);
    t.start();
  }

  @Override public void run() {
    while (true) {
      if (keepPrinting) {
        System.out.println("It works!");
      }
    }
  }
}