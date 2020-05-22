public class IdPool {
    private final LinkedList<Integer> availableIds = new LinkedList<Integer>();

    public IdPool() {
        for (int i = 1; i <= 1000; i++) {
            availableIds.add(i);
        }
    }

    public synchronized Integer getId() {
        return availabeIds.removeFirst();
    }

    public synchronized void releaseId(Integer id) {
        availableIds.add(id);
    }
}


class ThreadTask implements Runnable {
    private IdPool idPool;

    public ThreadTask(IdPool idPool) {
        this.idPool = idPool;
    }

    public void run() {
        Integer id = idPool.getId();
        System.out.println("Task " + id);
        idPool.releaseId(id);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int size = 10;
        int durationOfRun = 60;
        IdPool idPool = new IdPool();   
        // create thread pool with given size
        ExecutorService service = Executors.newFixedThreadPool(size); 

        // queue some tasks
        long startTime = System.currentTimeMillis();
        long endTime = startTime + (durationOfRun * 60 * 1000L);

        // Running it for 60 minutes
        while(System.currentTimeMillis() <= endTime) {
            service.submit(new ThreadTask(idPool));
        }

        // wait for termination        
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS); 
    }
}