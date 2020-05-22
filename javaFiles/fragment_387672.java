private void sleep() {
    try {
      Random r = new Random();    
      TimeUnit.SECONDS.sleep(r.nextInt(5));
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }