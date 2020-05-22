@Test
    public void testCached() throws InterruptedException {
        Map<String, Thread> map = new HashMap<>();
        ExecutorService service = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {

                if (!map.containsKey("WORKER")) {
                    Thread thread = new Thread(r, "WORKER");
                    thread.setDaemon(false);
                    map.put("WORKER", thread);
                }

                return map.get("WORKER");
            }
        });

        service.submit(task);
        Thread.sleep(10);
    }