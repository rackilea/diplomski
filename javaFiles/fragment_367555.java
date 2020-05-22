@Bean
public JobLauncher jobLauncher(final JobRepository jobRepository, final TaskExecutor taskExecutor) {

    final SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
    jobLauncher.setJobRepository(jobRepository);
    jobLauncher.setTaskExecutor(taskExecutor);
    return jobLauncher;
}

@Bean
public TaskExecutor taskExecutor() {

    SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
    taskExecutor.setDaemon(true);
    taskExecutor.setThreadPriority(Thread.MIN_PRIORITY);
    return taskExecutor;
}