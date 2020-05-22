threadB.interrupt();
 synchronized(this) {
     try {
         this.wait();
     } catch (InterruptedException ie) {
     }