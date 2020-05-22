public class Mindblower {

  public static void main(String[] args) {
    Thread ownThread = new Thread(new MindblowingRunnable());
    ownThread.start();

    // Other stuff that you want done concurrently on the main thread
  }

  private class MindblowingRunnable implements Runnable {
    @Override
    public void run() {
      // Stuff to be carried out in your thread
    }
  }
}