@Component
public class YourCronJobClass {

    private final YourCronJobExecutor yourCronJobExecutor;

    private final CronJobProcessor cronJobProcessor;

    @Autowired
    public PopulateCourseStateController(YourCronJobExecutor yourCronJobExecutor,
                                         CronJobProcessor cronJobProcessor) {
        this.yourCronJobExecutor = yourCronJobExecutor;
        this.cronJobProcessor = cronJobProcessor;
    }   

    @Scheduled(cron = "* */5 * * * *")
    public void fetchLatestResults() throws Exception {
        yourCronJobExecutor.start(cronJobProcessor::executeYouCronJob);
    }
}