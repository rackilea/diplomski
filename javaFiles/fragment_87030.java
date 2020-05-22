new Thread(new Runnable() {
  public void run() {
    try {
      callme(input);
    } catch(Exception t) {
       // appropriate error reporting here
    }
  }
}).start();