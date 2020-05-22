@Test
public void fineForFiveSeconds() throws InterruptedException {
  Thread thread = new Thread() {
    @Override
    public void run() {
      foo.doforever();
    }
  };

  thread.start();

  //Let the current thread sleep (not the created thread!)
  Thread.sleep(5000);

  assertTrue(thread.isAlive());
}