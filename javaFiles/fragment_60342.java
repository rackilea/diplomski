Runnable rb = new Runnable() {
    public void run() {
        synchronized (deque) {
             try {
                 String s = deque.takeLast();
                 System.out.println(s);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
        }
    }
};