private void loopInAnotherThread() {
   new Thread(new Runnable() {
       public void run() {
           // Your loop
       }
   }).start();
}