public class MainApp {

    public static void main(String[] args) {
        testme();
    }

    public static void testme() {
        ThreadPoolExecutor myown = new ExtendedExecutor(2,4,10, TimeUnit.DAYS.SECONDS, new ArrayBlockingQueue<Runnable>(2));

        myown.execute(() -> {
                throw new RuntimeException("Something went wrong");
  //            System.out.println("Hey there");
        }
    );
}


static class ExtendedExecutor extends ThreadPoolExecutor {

    public ExtendedExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t == null && r instanceof Future<?>) {
            try {
                Object result = ((Future<?>) r).get();
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset
            }
        }
        if (t != null) {
            System.out.println("We've got error");
            System.out.println(r==null?"null":"not null");
        }
    }
}