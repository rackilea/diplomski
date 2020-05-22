Scheduler sch = new StdSchedulerFactory().getScheduler();

JobDetail jobDetail = JobBuilder.newJob(MFRScheduler.class)
        .withIdentity("firstJob", "group1").build();
JobDetail jobDetail1 = JobBuilder.newJob(MFRSchedulerHouseKeeping.class)
        .withIdentity("houseKeepingJob", "group2").build();
Trigger trigger = TriggerBuilder
        .newTrigger()
        .withIdentity("firstJob", "group1")
        .withSchedule(
            CronScheduleBuilder.cronSchedule(schduledTime))
            .build();
Trigger houseKeepingTrigger = TriggerBuilder
        .newTrigger()
        .withIdentity("mfrJobHouseKeeping","group2")
        .withSchedule(
                CronScheduleBuilder.cronSchedule(cleanTrigerTime)
                )
        .build();

sch.start();
sch.scheduleJob(jobDetail, trigger);
sch.scheduleJob(jobDetail1, cleanTrigger);