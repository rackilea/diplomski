public static void main(String[] args) {
  new Thread(new Runnable() {
     public void run() {
        for (int i = 0; i < 30; i++) {
           System.out.println("i := " + i);
           try {
              Thread.sleep(1000);
           } catch (InterruptedException e) {
              e.printStackTrace();
           }
        }
     }
  }).start();
  try {
     frameTest();
  } catch (InterruptedException e) {
     e.printStackTrace();
  }
}