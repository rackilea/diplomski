public class TimerThreadTest {

  final static int NUM_THREADS = 5;
  final CountDownLatch latch = new CountDownLatch(NUM_THREADS);

  @Test
  public void threadTest() throws InterruptedException {
    System.out.println("Starting");
    Timer timer = new Timer(true);
    for (int i = 0; i < NUM_THREADS; i++){
      final int threadNo = i;
      TimerTask tt = new TimerTask() {
        @Override
        public void run() {
            latch.countDown();
            System.out.println("thread " + threadNo + " done");
        }
      };
      timer.schedule(tt, 1000);
    }
    latch.await();
    System.out.println("Main thread done");
  }
}