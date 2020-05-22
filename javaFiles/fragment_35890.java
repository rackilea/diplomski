@Configuration
@EnableScheduling
@ComponentScan("package.that.contains.the.runnable.job.bean")
public class JobConfiguration implements SchedulingConfigurer {

    private static final String cronExpression = "0 0 14 * * *";
    private static final String timeZone = "CET";

    @Autowired
    private Runnable cronJob;

    @Bean
    CronTrigger cronTrigger() {
        return new CronTrigger(cronExpression, TimeZone.getTimeZone(timeZone));
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addCronTask(new CronTask(job, cronTrigger()));
    }
}