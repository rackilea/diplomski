@Scheduled(fixedDelay = 10000)
public void runJob() throws Exception {
    JobParameters params = new JobParametersBuilder()
            .addString("JobID", String.valueOf(System.currentTimeMillis()))
            .toJobParameters();
    jobLauncher.run(job.csvFileToDatabaseJob(userJobCompletionNotificationListener, "C:\\Users\\Anik\\Desktop\\angular\\test.csv"), params);
}