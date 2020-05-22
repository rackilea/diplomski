synchronized (LOCK) {
   if (flag) {
      System.out.println("Notifying Joy");
      JOY = true;
      LOCK.notifyAll();
   }
   else {
      while (!JOY) {
         System.out.println("No Joy Yet...");
         try {
            LOCK.wait();
         }
         catch (InterruptedException e) {}
      }
      System.out.println("Joy has been achieved!");
   }
}