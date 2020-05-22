public void doStuff() {
    final Object finishSupplying = new Object();
    final BlockingQueue<Object> myList = new LinkedBlockingQueue<Object>();
    final Runnable supplier = new Runnable() {
        public void run() {
            for (int i = 0; i < 10; i++) {
                myList.add(i);
            }
        }
    };

    final Runnable consumer = new Runnable() {
        public void run() {
            while (true) {
                try {
                    final Object thing = myList.take();
                    if(thing == finishSupplying) break;
                    System.out.print(thing + " ");
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    };

    final ExecutorService exectutorService = Executors.newFixedThreadPool(2);
    final Future<?> supplierHandle = exectutorService.submit(supplier);
    final Future<?> consumerHandle = exectutorService.submit(consumer);
    try {
        supplierHandle.get();
    } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
    } catch (ExecutionException ex) {
        //PROBLEMS, handle
    }
    myList.add(finishSupplying);
    try {
        consumerHandle.get();
    } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
    } catch (ExecutionException ex) {
        //PROBLEMS, handle
    }
}