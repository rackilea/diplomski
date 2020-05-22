final URL url = new URL("http://whitefang34.com");
Runnable runnable = new Runnable() {
    public void run() {
        try {
            InputStream in = url.openStream();
            // process input
            in.close();
        } catch (IOException e) {
            // deal with exception
        }
    }
};

ExecutorService service = Executors.newFixedThreadPool(50);
long nextTime = System.currentTimeMillis();
while (true) {
    service.submit(runnable);
    long waitTime = nextTime - System.currentTimeMillis();
    Thread.sleep(Math.max(0, waitTime));
    nextTime += 200;
}