private CountDownLatch doneSignal = new CountDownLatch(1);

void main() throws InterruptedException{
  asyncDoSomething();
  //wait until doneSignal.countDown() is called
  doneSignal.await();
}

void onFinishDoSomething(){
  //do something ...
  //then signal the end of work
  doneSignal.countDown();
}