public static void main(String args[]) {  
  Thread iWillSurvive = new Thread(new Runnable() {
    public void run() {
      while(true) {
        // heat the CPU
      }
    }
  });
  iWillSurvive.start();
}