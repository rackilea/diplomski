protected void onResume() {
   super.onResume();
   handler.postDelayed(new Runnable() {
      public void run() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
      }
   }, 1000);    
 }