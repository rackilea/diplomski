public static class ParameterizedTask implements Runnable {
    private String log;
    //other parameters

    private TaskExecutor taskExecutor;

    public  ParameterizedTask(TaskExecutor taskExecutor) {
       this.taskExecutor = taskExecutor;
    }

    @Override
    public void run() {
        taskExecutor.execute(log);
    }
}