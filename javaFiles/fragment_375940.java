@Bean
public JobLauncher jobLauncher(JobRepository jobRepository, JobExplorer jobExplorer) {
    SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher() {
        @Override
        public JobExecution run(Job job, JobParameters jobParameters) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
            Set<JobExecution> running = jobExplorer.findRunningJobExecutions(job.getName());
            if (!running.isEmpty()) {
                throw new JobExecutionAlreadyRunningException("An instance of this job is already active: " + job.getName());
            }
            return super.run(job, jobParameters);
        }
    };
    simpleJobLauncher.setJobRepository(jobRepository);
    simpleJobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
    simpleJobLauncher.afterPropertiesSet();
    return simpleJobLauncher;
}