public class MyRunnable implements Runnable {
  private Data data;
  public MyRunnable(Data _data) {
    this.data = _data;
  }

  @override
  public void run() {
    ...
  }
}