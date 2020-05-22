try {
  Thread t = new Thread(new Runnable() {
         public void run() {
             new Server(9010);
         }
     });
  t.start();
  new Frame();
  t.join();
} catch(Exception e) { e.printStackTrace(); }