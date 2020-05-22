public class Mindblower {

  public static void main(String[] args) {
    Thread ownThread = new MindblowingThread();
    ownThread.start();

    // Other stuff that you want done concurrently on the main thread
  }

  private class MindblowingThread extends Thread {
    @Override
    public void run() {
      // Stuff to be carried out in your thread
    }
  }
}