CountDownLatch downloadDone = new CountDownLatch(1);

[...]

public synchronized void eodProcess() {
    //DO STUFF

    downloadDone.await();
  //DO STUFF
  }

public void update(){
    //CODE THAT DOWNLOADS FROM SERVER
    downloadDone.countDown();
}