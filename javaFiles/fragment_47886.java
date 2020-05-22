try {
      Thread.sleep(waitingTime);
      System.out.println(waitingTime);
  } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
  }