Runnable rb = new Runnable() {
    public synchronized void run() {
         try {
              String s = deque.takeLast();
              System.out.println(s);
         } catch (InterruptedException e) {
              e.printStackTrace();
         }
    }
};