Thread t42  = new Thread(new Runnable() {
      public void run() {
          myBackgroundMethod();
      }
 });
 t42.setDeamon(true);
 t42.start();