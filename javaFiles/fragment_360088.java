final CountDownLatch latch = new CountDownLatch(2);
new Thread(new Runnable(){
  @Override
  public void run(){
    // Do something
    latch.countDown()
  }
}).start();
new Thread(new Runnable(){
  @Override
  public void run(){
    // Do something
    latch.countDown()
  }
}).start();

latch.await()
startActivity(intent)