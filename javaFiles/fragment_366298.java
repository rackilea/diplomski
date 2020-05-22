while (!cont) {
    synchronized (this) {
       try {
           wait();
       } catch (Exception e) {
       }
    }
}