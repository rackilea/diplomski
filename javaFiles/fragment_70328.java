MyQueue<String> x = new MyQueue<>();

ExecutorService es = Executors.newFixedThreadPool(2);
for (int j = 0; j < 2; j++)
    es.submit(() -> {
        String tn = Thread.currentThread().getName();
        for (int i = 0; i < 2; i++)
            x.enqueue("v" + i);

        for (int i = 0; i < 2; i++) 
            System.out.println(tn + " deq: " + x.dequeue());
    });