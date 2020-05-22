@Bean
public JobLauncher jobLauncher() {
    final SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
    jobLauncher.setJobRepository(jobRepository);
    final SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
    jobLauncher.setTaskExecutor(simpleAsyncTaskExecutor);
    return jobLauncher;
 }