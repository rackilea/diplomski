Thread t = new Thread(new Runnable() {
    @Override
    public void run() {
        runTcpServer();
    }
});
t.start();