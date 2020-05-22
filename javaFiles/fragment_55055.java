public Thread doAction(){
  Thread insideThread = new Thread(() -> {
    //do something
  });

  return insideThread;
}