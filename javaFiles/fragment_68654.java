new Thread(new Runnable() {
  @Override
  public void run() {
    try {
      Thread.sleep(6000);
      runOnUiThread(new Runnable() {
        @Override
        public void run() {
          resetcolor();
          nextpage();
          rg.clearCheck();
          showdata();
        }
      });
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}).start();