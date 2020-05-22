ExecutorService service = Executors.newSingleThreadExecutor();
    Future<Message[]> future = service.submit(new Callable<Message[]>() {
        @Override
        public Message[] call() throws Exception {
            return Folder.search(/*...*/);
        }
    });

    try {
        Message[] messages = future.get(15, TimeUnit.SECONDS);
    }
    catch(TimeoutException e) {
        // timeout
    }