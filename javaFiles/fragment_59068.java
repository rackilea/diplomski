@Configuration
public class AppConfiguration {

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();
    }
}

@Controller
public class TriggerService {

    @Autowired
    private TaskScheduler scheduler;

    @Autowired
    private DAOService db;

    private ScheduledFuture job;        

    @GetMapping("/task1")
    @ResponseBody
    public void triggerMyTask(@RequestParam String cronExpression) {

        Runnable runnable = new Runnable() {            
            @Override
            public void run() {
                log.info(new Date());
                /**
                 * here You can do what You want with db
                 * using some DAOService
                 */         
                db.count();
            }
        };

        /**
         * cancel current task if You need
         */
        if(job != null) {
           job.cancel(true);
        }

        CronTrigger trigger = new CronTrigger(cronExpression);
        job = scheduler.schedule(runnable, trigger);
    }
}