private CyclicBarrier barrier = new CyclicBarrier(2);

void main() throws InterruptedException{
  asyncDoSomething();
  //wait until other party calls barrier.await()
  barrier.await();
}

void onFinishDoSomething() throws InterruptedException{
  //do something ...
  //then signal the end of work
  barrier.await();
}