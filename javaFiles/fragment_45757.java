Semaphore aPrintDone = new Semaphore(0);
  Semaphore bPrintDone= new Semaphore(0);

/**
 * methodA prints : A1 A2 A3
 */
 public void methodA() {
     try {
         System.out.println("A1");
         aPrintDone.release();
         bPrintDone.acquire();
         System.out.println("A2");
         aPrintDone.release();
         bPrintDone.acquire();
         System.out.println("A3");
         aPrintDone.release();
    }catch (InterruptedException e1) {
         e1.printStackTrace();
    }
  }

  /**
   * methodB prints : B1 B2 B3 
  */
  public void methodB() {
    try {
        aPrintDone.acquire();
        System.out.println("B1");
        bPrintDone.release();
        aPrintDone.acquire();
        System.out.println("B2");
        bPrintDone.release();
        System.out.println("B3");
    }catch (InterruptedException e1) {
        e1.printStackTrace();
    }
}