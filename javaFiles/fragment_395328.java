public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Map<String, String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        executor.submit(() -> {
            try {
                Thread.sleep(10000);

                lock.writeLock().lock();
                map.put("boo", "mar");
                lock.writeLock().unlock();

                System.out.println("A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            try {
                Thread.sleep(1);

                lock.writeLock().lock();
                map.put("foo", "bar");
                lock.writeLock().unlock();

                System.out.println("B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
    }