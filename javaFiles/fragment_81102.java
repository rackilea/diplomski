class ExampleMonitor implements SerialPortEventListener {
  boolean condition;

  public synchronized serialEvent(SerialPortEvent ev) {
    condition = true;
    notifyAll();
  }

  public synchronized void awaitCondition() throws InterruptedException {
    while(!condition) wait();
    condition = false;
  }