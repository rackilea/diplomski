class YourJob implements Job {
    //...
    @Override
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        //...
        if (someCondition) {
            try {
                context.getScheduler().shutdown();
            } catch (SchedulerException e) {
                // log or rethrow!
            }
        }
        //...