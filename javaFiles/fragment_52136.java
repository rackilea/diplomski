public class PollingSynchronizer {
  public static void main(String[] args) {
    MessageProcessor message = new MessageProcessor() {
      MessageProcessor message = new MessageProcessor() {
        public void run() {
          System.out.println("new run");
        }
      };
    };

    new Thread(message).start();
  }
}

class MessageProcessor implements Runnable {
  public void run() { System.out.println("old run"); }
}