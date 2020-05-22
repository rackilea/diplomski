mHandler = new Handler();

new Thread(new Runnable() {
   @Override
   public void run () {
     mHandler.post(new Runnable() {
      @Override
      public void run () {
        // place your action here
      }
     });
   }
 }).start();