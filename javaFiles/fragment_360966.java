SchedulerFactory sf = new StdSchedulerFactory();
Scheduler scheduler = sf.getScheduler();
scheduler.start();
JobDetail jobDetail = new JobDetail("someActionJob", Scheduler.DEFAULT_GROUP, ActionJob.class);

@SuppressWarnings("unchecked")
Map<String, Object> jobContext = jobDetail.getJobDataMap();
jobContext.put(QuartzActionConstants.NAMESPACE, "/the/action/namespace");
jobContext.put(QuartzActionConstants.NAME, "theActionName");
jobContext.put(QuartzActionConstants.METHOD, "theActionMethod");

Trigger trigger = new SimpleTrigger("actionJobTrigger", Scheduler.DEFAULT_GROUP, new Date(), null, SimpleTrigger.REPEAT_INDEFINITELY, 1000L);
scheduler.deleteJob("someActionJob", Scheduler.DEFAULT_GROUP);
scheduler.scheduleJob(jobDetail, trigger);