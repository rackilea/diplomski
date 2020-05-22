if (stopScript){
   runOnUiThread(new Runnable() {
     @Override
     public void run() {
        enableLayout();
    }
  });
}