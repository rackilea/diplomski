//main thread
AtomicBoolean foo = new AtomicBoolean(false);
while (...somecondition...){
  if(foo.compareAndSet(true, false)){
    //execute JS
  }
  //do some other work
}