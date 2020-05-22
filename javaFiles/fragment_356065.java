public class SimpleJob implements Job {
    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        SchedulerContext schedulerContext = null;
        try {
            schedulerContext = context.getScheduler().getContext();
        } catch (SchedulerException e1) {
            e1.printStackTrace();
        }
        ExternalInstance externalInstance =
            (ExternalInstance) schedulerContext.get("externalInstance");

        float avg = externalInstance.calculateAvg();
    }
}