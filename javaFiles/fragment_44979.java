volatile boolean b = true;
new Thread(() -> {
  while (true) {
    boolean lastB = b;
    while (b == lastB) {
      //If you want a delay between each check:
      try {
        Thread.sleep(/*delay in ms*/);
      } catch (InterruptedException ignored) {} 
    }
    //Do something if b changes
  }
}).start();