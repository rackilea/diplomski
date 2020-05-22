public static void main(String[] args) throws Exception{
        Thread[] threads = new Thread[THREADS_COUNT];

        int initialCount = Thread.activeCount();
        System.out.println("Initial count: " + initialCount);

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increment();

                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1){
            System.out.println(race);
            System.out.println(Thread.activeCount());
            Thread.yield();
        }
 }