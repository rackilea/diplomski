Thread t = new Thread(new Runnable() {
  public void run() {
    while (true) {
      b.setVisible(!b.isVisible());

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) { /* Handle exception /* }
    }
  }
});

t.start();