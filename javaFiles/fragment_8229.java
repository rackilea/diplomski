final CountDownLatch latch = new CountDownLatch(1);
scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
  @Override
  public void run() {
    loadInfo();
    latch.countDown();
  }
}, 1, 5, TimeUnit.MINUTES);
latch.await();