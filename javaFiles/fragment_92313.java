class WithFlag {
  private boolean flag;

  public synchronized void setToTrue() {
    if(!flag) {
      flag=true;
      notifyAll();
    }
  }
  public synchronized void waitForTrue() throws InterruptedException {
    while(!flag) wait();
  }
}