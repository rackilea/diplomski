public class CountingSemaphore {
  private int signals = 0;

  public synchronized void take() throws InterruptedException {
    while(this.signals == 0) wait();
    this.signals--;
  }

  public synchronized void release() {
     this.signals++;
     this.notify();
  }    
}