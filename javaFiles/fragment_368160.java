Properties props = new Properties();
props.setProperty("org.quartz.scheduler.skipUpdateCheck","true");

// set other properties ...such as
props.setProperty("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
props.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
props.setProperty("org.quartz.threadPool.threadCount", "4");

SchedulerFactory schdFact = new StdSchedulerFactory(props);