AtomicBoolean inProgress = new AtomicBoolean(false)
   /* Returns true if we acquired the lock */
   private boolean acquire() {
       return inProgress.compareAndSet(false, true);
   }
   /** Always release lock without determining if we in fact hold it */
   private void release() {
       inProgress.set(false);
   }