public class KeyManager {

  private volatile boolean genStarted = false;
  private final CountDownLatch keyGenerated = new CountDownLatch(1);
  private String key;

  public void genKey() {
    genStarted = true;
    new Thread(new Runnable() { 
      public void run() {
        key = operationThatTakesALongTime();
        keyGenerated.countDown();
      }
    }).start();
  }

  public String getKey() throws InterruptedException {
    if (!genStarted) throw new IllegalStateException("you must run genKey first");
    keyGenerated.await();
    return key;
  }
}