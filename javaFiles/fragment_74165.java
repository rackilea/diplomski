ThreadPoolTaskScheduler threadPoolTaskScheduler;
@PostConstruct
public void start() {
    .
    .
    calendar.setTime(formatter.parse(dateFromForm));
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int month = calendar.get(Calendar.MONTH);
    .
    .
    final String cornExp = "0 "+minutes+" "+hours+" "+day+" "+month+" "+year;

    threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    threadPoolTaskScheduler.setThreadNamePrefix("SpringCronJob");
    threadPoolTaskScheduler.initialize();

    threadPoolTaskScheduler.schedule(new Runable(){
        @Override
        public void run() {
            //run task
            //...
        }
    }
         , new CronTrigger(cornExp));
}

@PreDestroy
public void stop() {
    ScheduledExecutorService scheduledExecutorService = threadPoolTaskScheduler.getScheduledExecutor();
    scheduledExecutorService.shutdown();
}