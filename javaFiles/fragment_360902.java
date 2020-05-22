@EnableScheduling
@Configuration
public class BackgroundTaskScheduler {

    @Autowired
    private BackgroundTaskBean backgroundTaskBean;

    @Scheduled(cron = "${property.cronStatement}")
    public void backgroundTaskOne() {
        backgroundTaskBean.runTask();
    }
}