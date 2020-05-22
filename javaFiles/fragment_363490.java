class SimpleThreadFactory implements ThreadFactory {
    private int threadPriority;
    public Thread newThread(Runnable r) {
     Thread t = new Thread(r);
     t.setPriority(threadPriority);
     return t;
   }
 }