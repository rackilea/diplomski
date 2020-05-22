ExecutorService service = Executors.newFixedThreadPool(4);
    service.submit(new Runnable() {
        public void run() {
            sendSymbol();
        }
    });