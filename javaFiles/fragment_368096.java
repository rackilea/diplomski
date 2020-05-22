final Thread subject1 = new Thread(new Runnable() {

  public void run() {
    while (!Thread.interrupted()) {
      Thread.yield();
    }
    System.out.println("subject 1 stopped!");
  }
});
final Thread subject2 = new Thread(new Runnable() {

  public void run() {
    while (!Thread.interrupted()) {
      Thread.yield();
    }
    System.out.println("subject 2 stopped!");
  }
});
final Thread coordinator = new Thread(new Runnable() {

  public void run() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException ex) { }
    System.out.println("coordinator stopping!");
    subject1.interrupt();
    subject2.interrupt();
  }
});
subject1.start();
subject2.start();
coordinator.start();