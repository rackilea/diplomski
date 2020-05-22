public class ScheduledJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        final Date nextRun = something();

        Trigger trigger = newTrigger().
                startAt(nextRun).
                forJob(context.getJobDetail()).
                build();

        context.getScheduler().scheduleJob(trigger);
    }

}