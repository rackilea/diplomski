public class ParallelOr {

    static class LongTask implements Callable<Boolean> {

        private int milliseconds;
        private boolean val;

        public LongTask(int milliseconds, boolean val) {
            this.milliseconds = milliseconds;
            this.val = val;
        }

        @Override
        public Boolean call() throws Exception {
            try {
                Thread.sleep(milliseconds);
            } catch(Exception ex) {}
            return val;
        }
    }

    static boolean ParallelOr(List<Callable<Boolean>> tasks) {
        ExecutorService pool = Executors.newFixedThreadPool(tasks.size());
        ExecutorCompletionService<Boolean> completionService
                = new ExecutorCompletionService<Boolean>(pool);

        for(Callable<Boolean> task : tasks) {
            completionService.submit(task);
        }

        for(int i = 0; i < tasks.size(); i++) {
            try {
                Future<Boolean> result = completionService.take();
                if(result.get()) {
                    return true;
                }
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {}
        }

        return false;
    }


    public static void main(String[] args) {
        ArrayList<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();

        tasks.add(new LongTask(1000, true));
        tasks.add(new LongTask(500, false));
        tasks.add(new LongTask(6000, false));

        boolean result = ParallelOr(tasks);

        System.out.println(result);
    }
}