@Component
@EnableScheduling
public class AllJobLauncher {

    @Autowired
    JobExplorer jobExplorer;

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobRegistry jobRegistry;

    @Scheduled(cron = "${some.cron:0 0/10 * * * ?}")
    public void launchAllJobs() throws JobExecutionException {
        final List<String> jobNames = jobExplorer.getJobNames();

        for (final String jobName : jobNames) {
             final Job job = jobRegistry.getJob(getJobName(organizationId));
             final JobParameters jobParameters = new JobParametersBuilder() //build parameters

             jobLauncher.run(job, jobParameters);
         }
    }