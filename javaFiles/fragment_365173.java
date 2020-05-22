SchedulerFactory schedulerFactory = new StdSchedulerFactory();
// Retrieve a scheduler from schedule factory
Scheduler scheduler = null;
try {
    scheduler = schedulerFactory.getScheduler();
}
catch (SchedulerException e) {
    e.printStackTrace();
}

//Set up detail about the job 
JobDetail jobDetail = new JobDetail("jobDetail", "jobDetailGroup", ImplementedJob.class);
SimpleTrigger simpleTrigger = new SimpleTrigger("Trigger Name","defaultGroup", DATE);

// schedule a job with JobDetail and Trigger
scheduler.scheduleJob(jobDetail, simpleTrigger);
// start the scheduler
scheduler.start();