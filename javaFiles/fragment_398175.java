public class QuartzScheduler {

    public JobDetail job;
    public Trigger trigger;
    public Scheduler scheduler;

    public QuartzScheduler() throws SchedulerException, InterruptedException {
        job = JobBuilder.newJob(quartzJob.class)
                .withIdentity("quartzJob", "group1").build();

        trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("quartzTrigger", "group1")
                .startAt(futureDate(1, IntervalUnit.HOUR))
                .withSchedule(
                    SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInHours(1).repeatForever())
                .build();
        scheduler = new Scheduler(); //maybe do something else here.

        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }

    public void rescheduleCron(String cronExpression) throws SchedulerException {
        Trigger cronTrigger = TriggerBuilder
            .newTrigger()
            .withIdentity("quartzTrigger", "group1")
            .withSchedule(cronSchedule(cronExpression))
            .build();

        scheduler.rescheduleJob(trigger.getKey(), cronTrigger);    
    }
}

public static void main(String[] args) {
    QuartzScheduler sch= new QuartzScheduler(); 
    try {
        sch.rescheduleCron("0 0 * * * ?");
    } catch (SchedulerException ex) {
        Logger.getLogger(quartzScheduler.class.getName()).log(Level.SEVERE, null, ex);
    }
}