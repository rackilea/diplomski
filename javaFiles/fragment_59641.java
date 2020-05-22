Thread t1 = null;
private void exec() {
    t1 = new Thread(new Runnable() {
    public void run() {
    mBind.exec(3);
    }
  }).start();
}