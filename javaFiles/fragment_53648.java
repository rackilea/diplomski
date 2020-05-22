class AdminThread implements Runnable {
    // no constructor needed
    public void run() {
       ...
    }
}
...
Thread thread = new Thread(new AdminThread());
thread.setDaemon(false);
thread.start();