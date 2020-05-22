public class Broker {

  private static final String POISON_PILL = "__POISON_PILL__";
  private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

  public void put(String data) {
    queue.add(data);
  }

  public void doneProducing() {
    queue.add(POISON_PILL);
  }

  public String get() throws InterruptedException {
    String result = queue.take();
    if (result.equals(POISON_PILL)) {
      queue.add(POISON_PILL);
      return null;
    } else {
      return result;
    }
  }

}