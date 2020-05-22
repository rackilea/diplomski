public class BenchMarkTest {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        int threadNum = 2;
        ExecutorService taskExecutor = Executors.newFixedThreadPool(threadNum);
        List<FutureTask<Long>> taskList = new ArrayList<FutureTask<Long>>();

        try {

            for (int i = 0; i < 3 * 5; i++) {
                executor.submit(new ThreadTask(i, taskExecutor, taskList));
            }

            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {

        }

        for (FutureTask<Long> futureTask : taskList) {
            futureTask.get(); // doing a job similar to joining threads
        }
        taskExecutor.shutdown();
    }

}