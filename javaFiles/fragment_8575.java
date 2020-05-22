List<Thread> consumers = new ArrayList<>();
    for (int i = 0; i < noOfThreads; i++) {

        Thread consumer = new Thread(new Runnable() {

            String name = "Thread-" + UUID.randomUUID();

            @Override
            public void run() {
                try {
                    pc.consume(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        consumers.add(consumer);
        consumer.start();
    }
    for (Thread thread : consumers) {
        thread.join();
    }