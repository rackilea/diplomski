@Configuration
public class MyConf2 {

    @Bean(destroyMethod = "destroy")
    public ScheduledJob scheduledJob() {
        Timer jobTimer = new Timer(true);
        return new ScheduledJob(jobTimer);
    }

}