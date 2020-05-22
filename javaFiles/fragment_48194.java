// A sample logger class
public class Logger {
  static Queue<String> pending = new LinkedList<String>();
  static boolean writing = false;
  static PrintWriter pw = new PrintWriter("production.log", "UTF-8");

  public static void write() {
    if(!writing) {
      writing = true;
      pw.open();
      while(!pending.isEmpty()) {
        pw.println(pending.poll());
      }
      pw.close();
      writing = false;
    }
  }
}