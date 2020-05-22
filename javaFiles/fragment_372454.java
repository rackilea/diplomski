Thread t = new Thread(new Runnable() {
    public void run() {
        flip();
    }
});
t.start();