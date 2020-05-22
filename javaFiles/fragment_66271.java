public class MyTaskImpl {

    private static final ExecutorService JOB_EXEC_SVC = Executors.newFixedThreadExecutor(2);

    public void doTask() throws Exception {
        // Step 1
        // Step 2
        // Step 3 (below)
        JOB_EXEC_SVC.execute(() -> step3(param1, param2));
        // Step 4
        // Step 5 (below)
        JOB_EXEC_SVC.execute(() -> step5(param));
    }
}