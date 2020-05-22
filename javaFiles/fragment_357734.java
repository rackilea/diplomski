@Override
 public void run() {     

     for (int i = 0; i < 10000; i++) {
          if(i % 100) {
           mController.runOnUiThread(new Runnable() {
                 public void run() {
                    mController.triggered(i);
                 }
           });

    }

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
  }
}